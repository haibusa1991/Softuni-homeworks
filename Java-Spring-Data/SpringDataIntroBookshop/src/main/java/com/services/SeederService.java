package com.services;

import java.io.IOException;

public interface SeederService {

    void seedAuthors() throws IOException;

    void seedCategories() throws IOException;

    void seedBooks() throws IOException;

    void seedAll() throws IOException;
}
