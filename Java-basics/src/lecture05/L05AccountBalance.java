package lecture05;

import java.util.Scanner;

public class L05AccountBalance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double sum = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("NoMoreMoney")) {
                break;
            }

            if (Double.parseDouble(input)<0){
                System.out.println("Invalid operation!");
                break;
            }

            sum += Double.parseDouble(input);
            System.out.printf("Increase: %.2f\n",Double.parseDouble(input));

        }
        System.out.printf("Total: %.2f",sum);
    }
}

