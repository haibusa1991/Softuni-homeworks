package lecture03;

import java.util.Scanner;

public class ME01MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int spectators = Integer.parseInt(scanner.nextLine());

        double transportPrice;

        if (spectators < 5) {
            transportPrice = budget * 0.75;
        } else if (spectators < 10) {
            transportPrice = budget * 0.6;

        } else if (spectators < 25) {
            transportPrice = budget * 0.5;

        } else if (spectators < 50) {
            transportPrice = budget * 0.4;
        } else {
            transportPrice = budget * 0.25;
        }

        double ticketsPrice;
        if (category.equals("VIP")) {
            ticketsPrice = spectators * 499.99;
        } else {
            ticketsPrice = spectators * 249.99;
        }

        double difference = budget - ticketsPrice - transportPrice;

        if (difference<0) {
            System.out.printf("Not enough money! You need %.2f leva.",Math.abs(difference));
        } else {
            System.out.printf("Yes! You have %.2f leva left.",difference);
        }
    }
}
