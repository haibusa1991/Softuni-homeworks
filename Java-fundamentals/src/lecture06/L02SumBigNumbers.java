package lecture06;

import java.math.BigInteger;
import java.util.Scanner;

public class L02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger num1 = new BigInteger(scanner.nextLine());
        BigInteger num2 = new BigInteger(scanner.nextLine());
        System.out.println(new BigInteger(String.valueOf(num1.add(num2))));
    }
}
