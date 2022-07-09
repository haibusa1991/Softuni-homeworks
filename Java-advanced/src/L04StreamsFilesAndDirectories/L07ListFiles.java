package L04StreamsFilesAndDirectories;

import java.io.File;
import java.util.Arrays;

public class L07ListFiles {
    public static void main(String[] args) {
        File file = new File("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\Files-and-Streams");
        File[] files = file.listFiles();
        Arrays.stream(files).filter(File::isFile).forEach(e -> System.out.println(e.getName() + ": [" + e.length() + "]"));
        System.out.println();
    }
}
