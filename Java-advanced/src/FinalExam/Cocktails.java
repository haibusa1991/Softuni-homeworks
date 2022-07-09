package FinalExam;

import java.util.*;

public class Cocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredientsQueue::offer);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(freshnessStack::push);

        Map<String, Integer> cocktails = new HashMap<>();
        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredient = ingredientsQueue.poll();
            boolean hasToFinish = false;
            while (ingredient == 0) {
                if (!ingredientsQueue.isEmpty()) {
                    ingredient = ingredientsQueue.poll();
                } else {
                    hasToFinish = true;
                    break;
                }
            }
            if (hasToFinish) {
                break;
            }

            int freshness = freshnessStack.pop();
            int cocktail = ingredient * freshness;
            String cocktailName = null;
            switch (cocktail) {
                case 150:
                    cocktailName = "Pear Sour";
                    break;
                case 250:
                    cocktailName = "The Harvest";
                    break;
                case 300:
                    cocktailName = "Apple Hinny";
                    break;
                case 400:
                    cocktailName = "High Fashion";
                    break;
                default:
                    ingredient += 5;
                    ingredientsQueue.offer(ingredient);
            }
            if (cocktailName != null) {
                cocktails.putIfAbsent(cocktailName, 0);
                cocktails.put(cocktailName, cocktails.get(cocktailName) + 1);
            }
        }

        String result = cocktails.size() == 4
                ? "It's party time! The cocktails are ready!"
                : "What a pity! You didn't manage to prepare all cocktails.";
        System.out.println(result);
        int ingredientsSum = 0;
        while (!ingredientsQueue.isEmpty()) {
            ingredientsSum += ingredientsQueue.poll();
        }

        if (cocktails.size() < 4 && ingredientsSum > 0) {
            System.out.printf("Ingredients left: %d%n", ingredientsSum);
        }

        cocktails.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue()));
    }
}
