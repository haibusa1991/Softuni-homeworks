package cardealer.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SupplierService {
    void importSuppliers() throws IOException;

    void exportLocalSuppliers() throws IOException;
}
