package lecture08;

import java.util.Scanner;

public class E07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
//abv>1>1>2>2asdasd
//        pesho>2sis>1a>2akarate>4hexmaster
        int explosionPower = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '>' && i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                explosionPower += Integer.parseInt(Character.valueOf(input.charAt(i + 1)).toString());
            }
            if (currentChar != '>' && i + 1 <= input.length() && explosionPower > 0) {
                input.replace(i, i + 1, "П");
                explosionPower--;
            }
        }

        while (input.indexOf("П") != -1) {
            input.deleteCharAt(input.indexOf("П"));
        }

        System.out.println(input);
    }
}
