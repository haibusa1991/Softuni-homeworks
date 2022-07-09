package lecture06;

import java.math.BigInteger;
import java.util.Scanner;

public class L03BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bound = Integer.parseInt(scanner.nextLine());
        System.out.println(getFactorial(bound));
    }

    public static BigInteger getFactorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        BigInteger retVal = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            retVal = retVal.multiply(new BigInteger(String.valueOf(i)));
        }
        return retVal;
    }
}
