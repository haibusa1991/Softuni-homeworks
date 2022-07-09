package lecture03;

import java.util.Scanner;

public class ME03RecursiveFibonacci2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(fibonacci(num));
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return (fibonacci(n - 2) + fibonacci(n - 1));
    }
}
