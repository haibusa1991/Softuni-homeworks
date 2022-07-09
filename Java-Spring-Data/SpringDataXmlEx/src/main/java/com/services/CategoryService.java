package com.services;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CategoryService {
    void exportCategoryInfo() throws JAXBException, IOException;
}
