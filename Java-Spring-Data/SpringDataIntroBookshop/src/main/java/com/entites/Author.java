package com.entites;

import javax.persistence.*;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Entity(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author",fetch = FetchType.EAGER)
    private Set<Book> books;

    public Author() {
    }

    public Author(String lastName) {
        this.lastName = lastName;
    }

    public Author(String[] names) {
        this.firstName = names[0];
        this.lastName = names[1];
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }


}
