package L04StreamsFilesAndDirectories;

import java.io.*;

public class E09CopyAPicture {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\NakovAndCo.jpg");
        OutputStream os = new FileOutputStream("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\NakovAndCo-copy.jpg");
        int currentByte = is.read();
        while (currentByte != -1) {
            os.write(currentByte);
            currentByte = is.read();
        }
        is.close();
        os.close();
    }
}
