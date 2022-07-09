package lecture02;

import java.util.Scanner;

public class E05PrintPartOfAsciiTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        for (int i = n1; i <= n2; i++) {
            System.out.print("" + (char) i + " ");
        }
    }
}
