package Workshop02;

import java.util.Scanner;

public class L02RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getFactorial(Integer.parseInt(scanner.nextLine())));
    }

    private static int getFactorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * getFactorial(n - 1);
    }


}
