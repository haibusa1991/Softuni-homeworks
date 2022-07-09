package com.repositories;

import com.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByReleaseDateIsAfter(LocalDate date);

    List<Book> findAllByAuthorFirstNameAndAuthorLastName(String firstName, String lastName);

}
