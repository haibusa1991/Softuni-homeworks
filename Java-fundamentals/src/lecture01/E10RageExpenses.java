package lecture01;

import java.util.Scanner;

public class E10RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int numHeadsets = numLostGames / 2;
        int numMice = numLostGames / 3;
        int numKeyboard = numLostGames / 6;
        int numDisplay = numLostGames / 12;

        double rageExpenses = numHeadsets * headsetPrice +
                numMice * mousePrice +
                numKeyboard * keyboardPrice +
                numDisplay * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);

    }
}
