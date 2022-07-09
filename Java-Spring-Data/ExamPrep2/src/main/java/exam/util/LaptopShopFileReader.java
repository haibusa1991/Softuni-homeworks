package exam.util;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LaptopShopFileReader {
    public static String readFile(String fileName) {
        try {
            List<String> file = Files.readAllLines(Path.of(fileName));
            return String.join(System.lineSeparator(), file);
        } catch (Exception e) {
            return null;
        }
    }
}
