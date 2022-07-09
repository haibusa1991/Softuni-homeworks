package com.services;

import com.entites.Author;
import com.entites.Book;

import java.util.List;

public interface QueryService {
    List<Book> getAllBooksAfterYear(int year);

    List<Author> getAllAuthorsWithBookBeforeYear(int year);

    List<Author> getAllAuthorsOrderedByBookCount();

    List<Book> getAllBooksByAuthorOrdered(String firstName, String lastName);
}
