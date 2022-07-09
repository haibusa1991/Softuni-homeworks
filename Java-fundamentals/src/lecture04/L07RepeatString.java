package lecture04;

import java.util.Scanner;

public class L07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repetition = Integer.parseInt(scanner.nextLine());
        System.out.println(repeatString(input, repetition));
    }

    static String repeatString(String string, int n) {
        String output = "";
        for (int i = 0; i < n; i++) {
            output += string;
        }
        return output;
    }
}
