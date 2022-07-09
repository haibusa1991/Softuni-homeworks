package lecture03;

import java.util.Scanner;

public class E02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array1 = scanner.nextLine().split(" ");
        String[] array2 = scanner.nextLine().split(" ");

        for (String value2 : array2) {
            for (String value1 : array1) {
                if (value2.equals(value1)) {
                    System.out.print(value2 + " ");
                }
            }
        }
    }
}
