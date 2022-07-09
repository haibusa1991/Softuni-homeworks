package lecture04;

import java.util.Scanner;

public class E03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char lowerBound = scanner.nextLine().charAt(0);
        char upperBound = scanner.nextLine().charAt(0);

        System.out.println(getCharRange(lowerBound, upperBound));
    }

    public static String getCharRange(char a, char b) {
        String output = "";
        if (a > b) {
            char c = a;
            a = b;
            b = c;
        }
        for (int i = a + 1; i < b; i++) {
            output += (char) i + " ";
        }
        return output;
    }
}
