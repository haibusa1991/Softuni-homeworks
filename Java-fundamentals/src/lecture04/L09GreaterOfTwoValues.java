package lecture04;

import java.util.Scanner;

public class L09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String in1 = scanner.nextLine();
        String in2 = scanner.nextLine();

        switch (type) {
            case "int": {
                int a = Integer.parseInt(in1);
                int b = Integer.parseInt(in2);
                System.out.println(max(a, b));
            }
            break;
            case "char": {
                char a = in1.charAt(0);
                char b = in2.charAt(0);
                System.out.println(max(a, b));
            }
            break;
            case "string":
                System.out.println(max(in1, in2));
                break;

        }
    }


    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static char max(char a, char b) {
        return (char) Math.max(a, b);
    }

    static String max(String a, String b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
}
