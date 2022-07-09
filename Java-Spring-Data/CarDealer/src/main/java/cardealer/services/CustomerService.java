package cardealer.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CustomerService {
    void  importCustomers() throws IOException;

    void exportCustomersOrdered() throws IOException;

    void exportAllCustomers() throws IOException;
}
