package L04StreamsFilesAndDirectories;

import java.io.*;

public class L01ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\input.txt");
        int currentByte = fis.read();
        while (currentByte != -1) {
            System.out.print(Integer.toBinaryString(currentByte) + " ");
            currentByte = fis.read();
        }
    }
}
