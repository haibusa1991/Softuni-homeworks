package lecture08;

import java.util.Scanner;

public class E03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filepath = scanner.nextLine();
        String filename = filepath.substring(filepath.lastIndexOf('\\') + 1);
        System.out.println("File name: " + filename.substring(0, filename.lastIndexOf('.')));
        System.out.println("File extension: " + filename.substring(filename.lastIndexOf('.') + 1));

    }
}
