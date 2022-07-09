package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class L04AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        UnaryOperator<Double> addVat = e -> e * 1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(values).boxed().map(addVat).forEach(e-> System.out.printf("%.2f%n",e));
    }
}
