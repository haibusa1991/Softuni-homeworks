package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());
        if (decimal == 0) {
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> bin = new ArrayDeque<>();
        while (decimal > 0) {
            bin.push(decimal % 2);
            decimal /= 2;
        }
        while (!bin.isEmpty()) {
            System.out.print(bin.pop());
        }
    }
}
