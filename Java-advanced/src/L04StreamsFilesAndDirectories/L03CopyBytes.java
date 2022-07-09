package L04StreamsFilesAndDirectories;

import java.io.*;

public class L03CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\input.txt");
        FileOutputStream fos = new FileOutputStream("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\03.CopyBytesOutput.txt");
        int currentChar = fis.read();
        while (currentChar != -1) {
            if (currentChar == ' ' || currentChar==10) {
                fos.write(currentChar);
            } else {
                fos.write(String.valueOf(currentChar).getBytes());
            }
            currentChar = fis.read();
        }
    }
}