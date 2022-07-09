package com.services;

import com.entites.Author;
import com.entites.Book;
import com.repositories.AuthorRepository;
import com.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryServiceImpl implements QueryService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public QueryServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getAllBooksAfterYear(int year) {
        return bookRepository.findAllByReleaseDateIsAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<Author> getAllAuthorsWithBookBeforeYear(int year) {
        return authorRepository.
                findDistinctByBooksReleaseDateAfter(LocalDate.of(year, 12, 31))
                .stream()
                .filter(e->e.getBooks().size()>0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Author> getAllAuthorsOrderedByBookCount() {
        return authorRepository.findAll()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getBooks().size(), e1.getBooks().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksByAuthorOrdered(String firstName, String lastName) {
        List<Book> books = bookRepository.findAllByAuthorFirstNameAndAuthorLastName(firstName, lastName);

        return books.stream()
                .sorted(Comparator.comparing(Book::getReleaseDate).reversed().thenComparing(Book::getTitle))
                .collect(Collectors.toList());

    }
}
