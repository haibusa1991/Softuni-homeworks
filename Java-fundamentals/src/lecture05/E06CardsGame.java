package lecture05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            if (firstDeck.get(0) > secondDeck.get(0)) {
                firstDeck.add(firstDeck.get(0));
                firstDeck.add(secondDeck.get(0));
                firstDeck.remove(0);
                secondDeck.remove(0);
            } else if (firstDeck.get(0).equals(secondDeck.get(0))) {
                firstDeck.remove(0);
                secondDeck.remove(0);
            } else {
                secondDeck.add(secondDeck.get(0));
                secondDeck.add(firstDeck.get(0));
                firstDeck.remove(0);
                secondDeck.remove(0);
            }
        }

        if (secondDeck.isEmpty()) {
            System.out.printf("First player wins! Sum: %d", firstDeck.stream().mapToInt(Integer::intValue).sum());
        } else {
            System.out.printf("Second player wins! Sum: %d", secondDeck.stream().mapToInt(Integer::intValue).sum());

        }

    }
}
