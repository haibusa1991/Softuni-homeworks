package cardealer.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SaleService {
    void seedSales();

    void exportAllSales() throws IOException;
}
