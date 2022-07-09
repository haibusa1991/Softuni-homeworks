package lecture06;

import java.util.Scanner;

public class L05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String destination = scanner.nextLine();

            if (destination.equalsIgnoreCase("end")){
                break;
            }

            double price = Double.parseDouble(scanner.nextLine());
            double savings = 0;

            while (price > savings) {
                savings += Double.parseDouble(scanner.nextLine());
            }
            System.out.printf("Going to %s!\n", destination);
        }
    }
}
