package lecture06;

import java.util.Scanner;

public class E03SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int primeSum = 0;
        int nonPrimeSum = 0;
        long startTimer= System.nanoTime();

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            int value = Integer.parseInt(input);

            if (value < 0) {
                System.out.println("Number is negative.");
                continue;
            }

            if (value == 1) {
                nonPrimeSum++;
                continue;
            }

            boolean isNonPrime = false;
//            value = (int) Math.sqrt(value)+1;
            for (int i = 2; i < value; i++) {
                if (value % i == 0) {
                    nonPrimeSum += value;
                    isNonPrime = true;
                    break;
                }
            }

            if (!isNonPrime) {
                primeSum += value;
            }

        }
        System.out.println(System.nanoTime()-startTimer + " ns\n");
        System.out.printf("Sum of all prime numbers is: %d\nSum of all non prime numbers is: %d", primeSum, nonPrimeSum);
    }
}
