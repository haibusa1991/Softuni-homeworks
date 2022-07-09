package lecture08;


import java.util.Scanner;

public class L01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            StringBuilder sb = new StringBuilder(input);
            System.out.println(input + " = " + sb.reverse());
            input = scanner.nextLine();
        }
    }
}
