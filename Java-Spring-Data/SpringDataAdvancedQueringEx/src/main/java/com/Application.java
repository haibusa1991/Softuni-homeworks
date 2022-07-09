package com;

import com.model.entity.Book;
import com.model.entity.EditionType;
import com.service.AuthorService;
import com.service.BookService;
import com.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Application implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public Application(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedData();

//        System.out.println(task1("miNor"));
//        System.out.println(task2(EditionType.GOLD, 5000));
//        System.out.println(task3(5,40));
//        System.out.println(task4(2000));
//        System.out.println(task5("12-04-1992"));
//        System.out.println(task6("dy"));
//        System.out.println(task7("WOR"));
//        System.out.println(task8("gr"));
//        System.out.println(task9(40));
//        System.out.println(task10("Randy", "Graham"));
//        System.out.println(task11.sql("Antic Hay"));
//        System.out.println(task12("06 Jun 2013", 44));
//        System.out.println(task13(210));
        System.out.println(task14("Wand", "Morales "));

    }


    private String task1(String ageRestriction) {
        return bookService.getBookTitlesByAgeRestriction(ageRestriction);
    }

    private String task2(EditionType editionType, int copiesCount) {
        return bookService.getBookByEditionAndCopiesLessThan(editionType, copiesCount);
    }

    private String task3(double lowerBound, double upperBound) {
        return bookService.getBookTitleAndPriceOutsideRange(lowerBound, upperBound);
    }

    private String task4(int year) {
        return bookService.getBooksNotReleasedIn(year);
    }

    private String task5(String date) {
        return bookService.getBooksBefore(date);
    }

    private String task6(String endsWith) {
        return authorService.getAuthorsWithFirstNameEndingWith(endsWith);
    }

    private String task7(String contains) {
        return bookService.getBookTitleContains(contains);
    }

    private String task8(String startsWith) {
        return bookService.getBooksAuthorLastNameStartsWith(startsWith);
    }

    private String task9(int longerThan) {
        return bookService.getBooksWithTitleLongerThan(longerThan);
    }

    private String task10(String firstName, String lastName) {
        return bookService.getTotalBooksByAuthor(firstName, lastName);
    }

    private String task11(String bookName) {
        return bookService.getReducedInfoForBook(bookName);
    }

    private String task12(String releasedAfter, int copies) {
        return bookService.increaseCopiesOfBooksReleasedAfter(releasedAfter, copies);
    }

    private String task13(int copiesLessThan) {
        return bookService.removeBooksWithCopiesLessThan(copiesLessThan);
    }

    private String task14(String firstName, String lastName) {
        return bookService.callProcedureGetBookCountByAuthorName(firstName, lastName);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
