package com.service.impl;

import com.model.entity.*;
import com.repository.BookRepository;
import com.service.AuthorService;
import com.service.BookService;
import com.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }

    @Override
    public String getBookTitlesByAgeRestriction(String ageRestriction) {
        AgeRestriction restriction = AgeRestriction.valueOf(ageRestriction.toUpperCase());
        return bookRepository.findAllByAgeRestriction(restriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(System.lineSeparator()));
    }


    @Override
    public String getBookByEditionAndCopiesLessThan(EditionType editionType, int copiesCount) {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, copiesCount)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getBookTitleAndPriceOutsideRange(double lowerBound, double upperBound) {
        return bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(lowerBound), BigDecimal.valueOf(upperBound))
                .stream()
                .map(e -> String.format("%s - %.2f", e.getTitle(), e.getPrice()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getBooksNotReleasedIn(int year) {
        LocalDate dateBefore = LocalDate.of(year, 1, 1);
        LocalDate dateAfter = LocalDate.of(year, 12, 31);

        return bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(dateBefore, dateAfter)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getBooksBefore(String date) {
        LocalDate before = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return bookRepository.findAllByReleaseDateBefore(before)
                .stream()
                .map(e -> String.format("%s %s %.2f",
                        e.getTitle(),
                        e.getEditionType().toString(),
                        e.getPrice()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getBookTitleContains(String contains) {
        return bookRepository.findAllByTitleContaining(contains.toLowerCase())
                .stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getBooksAuthorLastNameStartsWith(String startsWith) {
        return bookRepository.findAllAuthorLastNameStartsWith(startsWith.toLowerCase())
                .stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getBooksWithTitleLongerThan(int longerThan) {
        int count = bookRepository.findAllWithTitleLongerThan(longerThan);
        return String.format("There are %d books with longer title than %d symbols", count, longerThan);

    }

    @Override
    public String getTotalBooksByAuthor(String firstName, String lastName) {
        int count = bookRepository.findBookCountByAuthor(firstName, lastName);
        return String.format("%s %s - %d copies", firstName, lastName, count);
    }

    @Override
    public String getReducedInfoForBook(String bookName) {
        String result = bookRepository.findReducedInfo(bookName);
        if (result != null) {
            result = result.replace(",", " ");
        }
        return result == null ? "No such book found" : String.format("%s %s", bookName, result);
    }

    @Override
    public String increaseCopiesOfBooksReleasedAfter(String releasedAfter, int copies) {
        LocalDate dateAfter = LocalDate.parse(releasedAfter, DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH));

        int booksModified = bookRepository.increaseByCopiesOfBooksReleasedAfter(dateAfter, copies);
        return String.format("%d books are released after %s, so total of %d book copies were added",
                booksModified,
                dateAfter,
                booksModified * copies);
    }

    @Override
    public String removeBooksWithCopiesLessThan(int copiesLessThan) {
        return String.format("%d books were deleted",
                bookRepository.removeBooksWithCopiesLessThan(copiesLessThan));
    }

    @Override
    public String callProcedureGetBookCountByAuthorName(String firstName, String lastName) {
        return String.format("%s %s has written %d books",
                firstName,
                lastName,
                bookRepository.callProcedureGetBookCountByAuthor(firstName, lastName));
    }
}
