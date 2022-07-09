package lecture02;

import java.math.BigDecimal;
import java.util.Scanner;

public class L03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < n; i++) {
            sum = sum.add(new BigDecimal(scanner.nextLine()));
        }
        System.out.println(sum);
    }

}
