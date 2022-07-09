package com.service;

import com.model.entity.Book;
import com.model.entity.EditionType;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    String getBookTitlesByAgeRestriction(String ageRestriction);

    String getBookByEditionAndCopiesLessThan(EditionType editionType, int copiesCount);

    String getBookTitleAndPriceOutsideRange(double lowerBound, double upperBound);

    String getBooksNotReleasedIn(int year);

    String getBooksBefore(String date);

    String getBookTitleContains(String contains);

    String getBooksAuthorLastNameStartsWith(String startsWith);

    String getBooksWithTitleLongerThan(int longerThan);

    String getTotalBooksByAuthor(String firstName, String lastName);

    String getReducedInfoForBook(String bookName);

    String increaseCopiesOfBooksReleasedAfter(String releasedAfter, int copies);

    String removeBooksWithCopiesLessThan(int copiesLessThan);

    String callProcedureGetBookCountByAuthorName(String firstName, String lastName);
}
