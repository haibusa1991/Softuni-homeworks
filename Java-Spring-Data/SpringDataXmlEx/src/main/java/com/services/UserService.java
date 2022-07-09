package com.services;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface UserService {
    void exportSuccessfullySoldProducts() throws JAXBException, IOException;

    void exportUsersAndSoldItems() throws JAXBException, IOException;
}
