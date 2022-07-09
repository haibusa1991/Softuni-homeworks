package L03SetsAndMapsAdvanced;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L03Voina {
    public static void main(String[] args) {
        int DECK_SIZE = 20;
        Scanner scanner = new Scanner(System.in);
        Set<Integer> deck1 = new LinkedHashSet<>();
        for (int i = 0; i < DECK_SIZE; i++) {
            deck1.add(scanner.nextInt());
        }
        scanner.nextLine();

        Set<Integer> deck2 = new LinkedHashSet<>();
        for (int i = 0; i < DECK_SIZE; i++) {
            deck2.add(scanner.nextInt());
        }
        int round = 50;
        while (round-- > 0 || deck1.isEmpty() || deck2.isEmpty()) {
            int card1 = deck1.iterator().next();
            int card2 = deck2.iterator().next();
            deck1.remove(card1);
            deck2.remove(card2);

            if(card1>card2){
                deck1.add(card1);
                deck1.add(card2);
            }else if(card2>card1){
                deck2.add(card1);
                deck2.add(card2);
            }
        }
        if(deck2.size()>deck1.size()){
            System.out.println("Second player win!");
        }else if(deck2.size()<deck1.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Draw");
        }
    }
}
