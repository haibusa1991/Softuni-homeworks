package lecture01;

import java.util.Scanner;

public class ME05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLetters = Integer.parseInt(scanner.nextLine());
        String message = "";
        for (int i = 0; i < numLetters; i++) {
            int inputLetter = Integer.parseInt(scanner.nextLine());
            int button = inputLetter % 10;
            int numDigits = (int) (Math.floor(Math.log10(inputLetter)) + 1);
            int offset = (button - 2) * 3;
            if (button == 8 || button == 9) offset++;
            if (button == 0) {
                offset = -64;
            }
            char currentLetter = (char) (97 + offset + numDigits - 1);
            message += currentLetter;
        }
        System.out.println(message);
    }

}
