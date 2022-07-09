package lecture05;

import java.util.Scanner;

public class ME03StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasFoundN = false;
        boolean hasFoundO = false;
        boolean hasFoundC = false;

        String finalString = "";
        String stringToCommit = "";

        while (true) {
            String input = scanner.nextLine();
            char currentChar = input.charAt(0);

            if (hasFoundN && hasFoundO && hasFoundC) {
                hasFoundN = false;
                hasFoundO = false;
                hasFoundC = false;
                finalString = finalString.concat(stringToCommit).concat(" ");
                stringToCommit="";
            }

            if (input.equalsIgnoreCase("end")) {
                break;
            }

            if ((currentChar >= 65 && currentChar <= 90) ||
                    (currentChar >= 97 && currentChar <= 122)) {

                if (currentChar == 110 && !hasFoundN) {
                    hasFoundN = true;
                    continue;
                }

                if (currentChar == 111 && !hasFoundO) {
                    hasFoundO = true;
                    continue;
                }

                if (currentChar == 99 && !hasFoundC) {
                    hasFoundC = true;
                    continue;
                }

                stringToCommit = stringToCommit.concat(Character.toString(currentChar));
            }
        }
        System.out.print(finalString);
    }
}
