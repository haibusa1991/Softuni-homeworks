package JsonEx.services.seedService;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {
    void seedUsers() throws IOException;

    void seedCategories() throws FileNotFoundException;

    void seedProducts() throws FileNotFoundException;

    void seedAll() throws IOException;
}
