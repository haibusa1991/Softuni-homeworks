package lecture08;

import java.util.Scanner;

public class E04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder(input.length());
        for(char currentChar : input.toCharArray()){
            output.append((char) (currentChar+3));
        }
        System.out.println(output);
    }
}
