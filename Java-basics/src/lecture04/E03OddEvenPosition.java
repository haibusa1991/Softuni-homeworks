package lecture04;

import java.util.Scanner;

public class E03OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNumbers = Integer.parseInt(scanner.nextLine());

        double maxOddNumber = Double.NEGATIVE_INFINITY;
        double minOddNumber = Double.POSITIVE_INFINITY;
        double maxEvenNumber = Double.NEGATIVE_INFINITY;
        double minEvenNumber = Double.POSITIVE_INFINITY;

        double oddSum = 0;
        double evenSum = 0;

        for (int i = 1; i <= numNumbers; i++) {
            double value = Double.parseDouble(scanner.nextLine());

            if (i % 2 != 0) {
                oddSum += value;

                if (value < minOddNumber) {
                    minOddNumber = value;
                }

                if (value > maxOddNumber) {
                    maxOddNumber = value;
                }
            } else {
                evenSum += value;

                if (value < minEvenNumber) {
                    minEvenNumber = value;
                }

                if (value > maxEvenNumber) {
                    maxEvenNumber = value;
                }
            }
        }

        System.out.printf("OddSum=%.2f,\n", oddSum);
        if (oddSum == 0) { //check if needs to be ==Double.MAX_VALUE
            System.out.println("OddMin=No,\nOddMax=No,");
        } else {
            System.out.printf("OddMin=%.2f,\n", minOddNumber);
            System.out.printf("OddMax=%.2f,\n", maxOddNumber);
        }

        System.out.printf("EvenSum=%.2f,\n", evenSum);
        if (evenSum == 0) { //check if needs to be ==Double.MAX_VALUE
            System.out.println("EvenMin=No,\nEvenMax=No\n");
        } else {
            System.out.printf("EvenMin=%.2f,\n", minEvenNumber);
            System.out.printf("EvenMax=%.2f", maxEvenNumber);
        }
    }
}
