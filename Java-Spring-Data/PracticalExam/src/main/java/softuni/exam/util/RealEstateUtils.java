package softuni.exam.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RealEstateUtils {
    public static String readFile(String filepath) throws IOException {
        return String.join(System.lineSeparator(), Files.readAllLines(Path.of(filepath)));
    }

    public static <T> Unmarshaller getUnmarshaller(Class<T> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            return context.createUnmarshaller();
        } catch (Exception e) {
            return null;
        }
    }
}
