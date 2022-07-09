package lecture04;

import java.util.Scanner;

public class ME01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String input = scanner.nextLine();
        switch (type) {
            case "int":
                printType(Integer.parseInt(input));
                break;
            case "real":
                printType((Double.parseDouble(input)));
                break;
            default:
                printType(input);
        }
    }

    private static void printType(int n) {
        System.out.println(n * 2);
    }

    public static void printType(double n) {
        System.out.printf("%.2f", n * 1.5);
    }

    public static void printType(String s) {
        System.out.println("$" + s + "$");
    }
}
