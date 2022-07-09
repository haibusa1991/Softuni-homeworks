package com;

import com.services.QueryService;
import com.services.SeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Application implements CommandLineRunner {
    private final SeederService seederService;
    private final QueryService queryService;

    @Autowired
    public Application(SeederService seederService, QueryService queryService) {
        this.seederService = seederService;
        this.queryService = queryService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seederService.seedAll();

        System.out.println("TASK 1");
        queryService.getAllBooksAfterYear(2000)
                .forEach(e -> System.out.printf("%s, released on %s%n", e.getTitle(), e.getReleaseDate()));

        System.out.println("TASK 2");
        queryService.getAllAuthorsWithBookBeforeYear(1990)
                .forEach(e -> System.out.printf("%s %s has released %d books with at least one before 1990%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getBooks().size()));

        System.out.println("TASK 3");
        queryService.getAllAuthorsOrderedByBookCount()
                .forEach(e -> System.out.printf("%s %s has released %d books%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getBooks().size()));

        System.out.println("TASK 4");
        queryService.getAllBooksByAuthorOrdered("George", "Powell")
                .forEach(e -> System.out.printf("%s - released %s in %d copies%n",
                        e.getTitle(),
                        e.getReleaseDate(),
                        e.getCopies()));
    }
}
