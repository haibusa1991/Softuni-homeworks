package midExamExercise;

import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2517#0
public class M01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sumWithoutVat = 0;
        while (!input.equals("special") && !input.equals("regular")) {
            double currentPrice = Double.parseDouble(input);
            if (currentPrice < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            sumWithoutVat += currentPrice;
            input = scanner.nextLine();
        }

        double totalSum = sumWithoutVat * 1.2;
        double vat = sumWithoutVat * 0.2;
        if (input.equals("special")) {
            totalSum *= 0.9;
        }

        if (sumWithoutVat == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("Congratulations you've just bought a new computer!\n" +
                            "Price without taxes: %.2f$\n" +
                            "Taxes: %.2f$\n" +
                            "-----------\n" +
                            "Total price: %.2f$",
                    sumWithoutVat,
                    vat,
                    totalSum);

        }
    }
}
