package lecture01;

import java.util.Scanner;

public class ME04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String output = "";
        for (int i = input.length(); i > 0; i--) {
            output += input.charAt(i - 1);
        }
        System.out.println(output);
    }
}
