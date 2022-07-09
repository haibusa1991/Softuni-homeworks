package L03SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class E08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();

        String turn = scanner.nextLine();
        while (!turn.equals("JOKER")) {
            String name = turn.split(":\\s*")[0];
            players.putIfAbsent(name, new HashSet<>());
            Set<String> newCards = players.get(name);
            newCards.addAll(Arrays.stream(turn.split(":\\s*")[1].split(",\\s*")).collect(Collectors.toList()));
            players.put(name, newCards);
            turn = scanner.nextLine();
        }
        players.forEach((k, v) -> System.out.println(k + ": " + getSum(v)));
    }

    private static int getSum(Set<String> cards) {
        int sum = 0;
        for (String card : cards) {
            int multiplier = 1;
            char suite = card.charAt(card.length() - 1);
            switch (suite) {
                case 'S':
                    multiplier = 4;
                    break;
                case 'H':
                    multiplier = 3;
                    break;
                case 'D':
                    multiplier = 2;
                    break;
            }
            String value = card.substring(0, card.length() - 1);
            switch (value) {
                case "J":
                    value = "11";
                    break;
                case "Q":
                    value = "12";
                    break;
                case "K":
                    value = "13";
                    break;
                case "A":
                    value = "14";
                    break;
            }
            int numValue = Integer.parseInt(value);
            sum += multiplier * numValue;
        }
        return sum;
    }
}
