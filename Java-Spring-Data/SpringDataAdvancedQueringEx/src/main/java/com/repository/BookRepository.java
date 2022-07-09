package com.repository;

import com.model.entity.AgeRestriction;
import com.model.entity.Book;
import com.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lessThan, BigDecimal greaterThan);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    @Query("""
            SELECT b.title
            FROM Book b
            WHERE LOWER(b.title) LIKE %:contains%
            """)
    List<String> findAllByTitleContaining(String contains);

    @Query("""
            SELECT CONCAT(b.title,'(',b.author.firstName,' ',b.author.lastName,')')
            FROM Book b
            WHERE LOWER(b.author.lastName) LIKE :startsWith%
            """)
    List<String> findAllAuthorLastNameStartsWith(String startsWith);

    @Query("""
            SELECT COUNT (b.title) AS c
            FROM Book b
            WHERE LENGTH(b.title)>:length
            """)
    int findAllWithTitleLongerThan(int length);


    @Query("""
            SELECT SUM (b.copies) AS c
            FROM Book b
            WHERE b.author.firstName = :firstName AND b.author.lastName= :lastName
            """)
    int findBookCountByAuthor(String firstName, String lastName);

    @Query("""
            SELECT b.editionType, b.ageRestriction,b.price
            FROM Book b
            WHERE b.title = :bookName
            """)
    String findReducedInfo(String bookName);

    @Transactional
    @Modifying
    @Query("""
            UPDATE Book b
            SET b.copies = b.copies * :copies
            WHERE b.releaseDate > :after
            """)
    int increaseByCopiesOfBooksReleasedAfter(LocalDate after, int copies);

    @Transactional
    @Modifying
    @Query("""
            DELETE FROM Book b
            WHERE b.copies < :copiesCount
            """)
    int removeBooksWithCopiesLessThan(int copiesCount);

    @Query(value = """
            SELECT (udf_get_book_count_by_author(:firstName, :lastName))
            """,nativeQuery = true)
    int callProcedureGetBookCountByAuthor(String firstName, String lastName);

}
