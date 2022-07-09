package lecture01WorkingWithAbstraction.E03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rank rank = Rank.valueOf(scanner.nextLine());
        Suit suit = Suit.valueOf(scanner.nextLine());

        System.out.printf("Card name: %s of %s; Card power: %d",
                rank.name(),
                suit.name(),
                rank.getRank()+ suit.getPower());
    }

}
