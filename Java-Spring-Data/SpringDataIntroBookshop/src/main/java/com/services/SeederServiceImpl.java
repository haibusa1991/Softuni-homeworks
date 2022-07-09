package com.services;

import com.entites.*;
import com.repositories.AuthorRepository;
import com.repositories.BookRepository;
import com.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.utils.Filenames.*;

@Service
public class SeederServiceImpl implements SeederService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final CategoriesService categoriesService;
    private final AuthorService authorService;

    @Autowired
    public SeederServiceImpl(AuthorRepository authorRepository,
                             BookRepository bookRepository,
                             CategoryRepository categoryRepository,
                             CategoriesService categoriesService,
                             AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.categoriesService = categoriesService;
        this.authorService = authorService;
    }

    @Autowired


    @Override
    public void seedAuthors() throws IOException {
        this.authorRepository.saveAll(getAuthorsFromDisk());
    }

    @Override
    public void seedCategories() throws IOException {
        this.categoryRepository.saveAll(getCategoriesFromDisk());
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(BOOKS_FILE_PATH))
                .stream()
                .map(e -> e.split("\\s+"))
                //          1 20/01/1998 27274 15.31 2 Absalom
                //          0      1       2      3  4    5

                .map(e -> {
                    EditionType type = EditionType.values()[Integer.parseInt(e[0])];
                    LocalDate releaseDate = LocalDate.parse(e[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
                    int numCopies = Integer.parseInt(e[2]);
                    BigDecimal price = new BigDecimal(e[3]);
                    AgeRestriction restriction = AgeRestriction.values()[Integer.parseInt(e[4])];
                    String title = Arrays.stream(e).skip(5).collect(Collectors.joining(" "));

                    Book book = new Book(title, type, price, numCopies, restriction);
                    book.setReleaseDate(releaseDate);
                    book.setCategories(categoriesService.getRandomCategories());
                    book.setAuthor(authorService.getRandomAuthor());
                    return book;

                })
                .forEach(bookRepository::save);
    }

    @Override
    public void seedAll() throws IOException {
        seedAuthors();
        seedCategories();
        seedBooks();
    }

    private List<Author> getAuthorsFromDisk() throws IOException {
        return Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .stream()
                .map(e -> e.split("\\s+"))
                .map(Author::new)
                .collect(Collectors.toList());
    }

    private List<Category> getCategoriesFromDisk() throws IOException {
        return Files.readAllLines(Path.of(CATEGORIES_FILE_PATH))
                .stream()
                .filter(e -> !e.trim().isEmpty())
                .map(Category::new)
                .collect(Collectors.toList());
    }
}
