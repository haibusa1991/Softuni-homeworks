package cardealer.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CarService {
    void importCars() throws IOException;

    void exportToyota() throws IOException;

    void exportCarsWithParts() throws IOException;
}
