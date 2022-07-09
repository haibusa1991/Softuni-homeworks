package finalExam;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder myString = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String command = input.split(" ")[0];
            switch (command) {
                case "Change": {
                    String replaced = input.split(" ")[1];
                    String replacement = input.split(" ")[2];
                    while (myString.indexOf(replaced) != -1) {
                        myString.replace(myString.indexOf(replaced),
                                myString.indexOf(replaced) + 1,
                                replacement);
                    }
                    System.out.println(myString);
                    break;
                }
                case "Includes": {
                    String otherString = input.split(" ")[1];
                    if (myString.indexOf(otherString) != -1) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                }
                case "End": {
                    String otherString = input.split(" ")[1];
                    String lastChars = myString.substring(myString.length() - otherString.length());
                    if (otherString.equals(lastChars)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                }
                case "Uppercase": {
                    myString = new StringBuilder(myString.toString().toUpperCase());
                    System.out.println(myString);
                    break;
                }
                case "FindIndex": {
                    String stringToFind = input.split(" ")[1];
                    System.out.println(myString.indexOf(stringToFind));
                    break;
                }
                case "Cut": {
                    int startIndex = Integer.parseInt(input.split(" ")[1]);
                    int endIndex = Integer.parseInt(input.split(" ")[2]) + startIndex;
                    myString = new StringBuilder(myString.substring(startIndex, endIndex));
                    System.out.println(myString);
                    break;
                }
            }
            input = scanner.nextLine();
        }
    }
}
