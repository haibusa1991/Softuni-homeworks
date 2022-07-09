package lecture02;

import java.math.BigDecimal;
import java.util.Scanner;

public class ME03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal numA = new BigDecimal(scanner.nextLine());
        BigDecimal numB = new BigDecimal(scanner.nextLine());
        BigDecimal eps = numA.subtract(numB);
        BigDecimal epsTolerance = new BigDecimal("0.000001");
        eps = eps.abs();
        if (eps.compareTo(epsTolerance) == -1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
