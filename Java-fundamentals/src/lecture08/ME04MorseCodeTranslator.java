package lecture08;

import java.util.Scanner;

public class ME04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] characters = scanner.nextLine().split(" ");
        StringBuilder output = new StringBuilder();
        for (String currentChar : characters) {
            output.append(getEnglishChar(currentChar));
        }
        System.out.println(output);
    }

    private static String getEnglishChar(String morseChar){
        switch (morseChar){
            case ".-":
                return "A";
            case "-...":
                return "B";
            case "-.-.":
                return "C";
            case "-..":
                return "D";
            case ".":
                return "E";
            case "..-.":
                return "F";
            case "--.":
                return "G";
            case "....":
                return "H";
            case "..":
                return "I";
            case ".---":
                return "J";
            case "-.-":
                return "K";
            case ".-..":
                return "L";
            case "--":
                return "M";
            case "-.":
                return "N";
            case "---":
                return "O";
            case ".--.":
                return "P";
            case "--.-":
                return "Q";
            case ".-.":
                return "R";
            case "...":
                return "S";
            case "-":
                return "T";
            case "..-":
                return "U";
            case "...-":
                return "V";
            case ".--":
                return "W";
            case "-..-":
                return "X";
            case "-.--":
                return "Y";
            case "--..":
                return "Z";
            case "|":
                return " ";
        }
        return "";
    }
}
