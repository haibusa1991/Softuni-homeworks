package lecture02;

import java.util.Scanner;

public class L06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String output = "";
        for (int i = 0; i < 3; i++) {
            output += scanner.nextLine().charAt(0);
        }
        System.out.println(output);
    }
}
