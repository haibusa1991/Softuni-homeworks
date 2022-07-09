package playground;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        double firstPayment = Double.parseDouble(scanner.next());
        double firstPayment = Double.parseDouble(scanner.nextLine());

        boolean hasFailed=false;

        if (firstPayment<0){
            System.out.println("Invalid operation!");
            firstPayment=0;
            hasFailed=true;
        } else {
            System.out.printf("Increase: %.2f\n", firstPayment);
        }

        while (true) {
            if(hasFailed) break;

            String word = scanner.nextLine();
            if (word.equals("NoMoreMoney")) break;
            else {
//                double num = scanner.nextDouble();
                double num = Double.parseDouble(word);
                if (num >= 0) {
                    firstPayment += num;
                    System.out.printf("Increase: %.2f\n", num);
                } else {
                    System.out.println("Invalid operation!");
                    break;
                }
            }
        }
        System.out.printf("Total: %.2f", firstPayment);
    }
}
