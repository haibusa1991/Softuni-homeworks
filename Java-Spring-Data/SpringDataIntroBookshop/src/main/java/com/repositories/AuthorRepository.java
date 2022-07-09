package com.repositories;

import com.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findAuthorById(Integer authorId);

    List<Author> findDistinctByBooksReleaseDateAfter(LocalDate date);

    List<Author> findAll();
    }
