package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Random;
import java.util.Scanner;

public class L03HexToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//        while (!scanner.nextLine().equals("exit")) {
//            int currentRandom = random.nextInt(Integer.MAX_VALUE);
//            System.out.println("Random integer: " + currentRandom);
//            String toHex = decToHex(currentRandom);
//            System.out.println("Converted to hexadecimal: " + toHex);
//            System.out.println("Converted back to decimal: " + hexToDec(toHex));
//        }
        System.out.println(hexToDec(scanner.nextLine()));
    }

    private static int hexToDec(String hex) {
        hex = new StringBuilder(hex).reverse().toString();
        int result = 0;
        for (int i = 0; i < hex.length(); i++) {
            char currentChar = Character.toUpperCase(hex.charAt(i));
            int currentNum;
            switch (currentChar) {
                case 'A':
                    currentNum = 10;
                    break;
                case 'B':
                    currentNum = 11;
                    break;
                case 'C':
                    currentNum = 12;
                    break;
                case 'D':
                    currentNum = 13;
                    break;
                case 'E':
                    currentNum = 14;
                    break;
                case 'F':
                    currentNum = 15;
                    break;
                default:
                    currentNum = Integer.parseInt(String.valueOf(currentChar));
                    break;
            }
            result += currentNum * Math.pow(16, i);
        }
        return result;
    }

    private static String decToHex(int dec) {
        if (dec == 0) {
            return "0";
        }

        ArrayDeque<String> hex = new ArrayDeque<>();
        while (dec > 0) {
            String mod = (dec % 16) + "";
            switch (mod) {
                case "10":
                    mod = "A";
                    break;
                case "11":
                    mod = "B";
                    break;
                case "12":
                    mod = "C";
                    break;
                case "13":
                    mod = "D";
                    break;
                case "14":
                    mod = "E";
                    break;
                case "15":
                    mod = "F";
                    break;
            }
            hex.push(mod);
            dec /= 16;
        }
        StringBuilder output = new StringBuilder("");
        while (!hex.isEmpty()) {
            output.append(hex.pop());
        }
        return output.toString();
    }
}

