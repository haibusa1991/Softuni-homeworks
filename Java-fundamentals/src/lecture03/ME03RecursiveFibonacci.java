package lecture03;

import java.util.Scanner;

public class ME03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] values = new int[num];
        if (num >= 2) {
            values[0] = 1;
            values[1] = 1;
            for (int i = 2; i < values.length; i++) {
                values[i] = values[i - 1] + values[i - 2];
            }
            System.out.println(values[num - 1]);
        } else {
            System.out.println(num);
        }
    }
}
