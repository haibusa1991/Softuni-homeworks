package Exam;

import java.util.Scanner;

public class T02MaidenParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double partyPrice = Double.parseDouble(scanner.nextLine());
        int numLoveLetters = Integer.parseInt(scanner.nextLine());
        int numWaxRoses = Integer.parseInt(scanner.nextLine());
        int numKeychains = Integer.parseInt(scanner.nextLine());
        int numCaricatures = Integer.parseInt(scanner.nextLine());
        int numSurprises = Integer.parseInt(scanner.nextLine());

        double finalPrice = numLoveLetters * 0.6 + numWaxRoses * 7.2 + numKeychains * 3.6 + numCaricatures * 18.2 + numSurprises * 22;

        if (numLoveLetters + numWaxRoses + numKeychains + numCaricatures + numSurprises >= 25) {
            finalPrice *= 0.65;
        }

        finalPrice *= 0.9;

        if (finalPrice >= partyPrice) {
            System.out.printf("Yes! %.2f lv left.", finalPrice - partyPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", partyPrice - finalPrice);
        }

    }
}
