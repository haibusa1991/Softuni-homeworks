package com.services;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SeedService {

    void seedUsers() throws JAXBException, FileNotFoundException;

    void seedCategories() throws FileNotFoundException, JAXBException;

    void seedProducts() throws FileNotFoundException, JAXBException;

    void seedAll() throws JAXBException, FileNotFoundException;
}
