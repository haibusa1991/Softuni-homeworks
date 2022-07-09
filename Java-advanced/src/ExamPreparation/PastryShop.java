package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(liquids::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> produce = new LinkedHashMap<>() {{
            put("Biscuit", 0);
            put("Cake", 0);
            put("Pie", 0);
            put("Pastry", 0);
        }};

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            int result = liquid + ingredient;
            String pastry = null;
            switch (result) {
                case 25:
                    pastry = "Biscuit";
                    break;
                case 50:
                    pastry = "Cake";
                    break;
                case 75:
                    pastry = "Pastry";
                    break;
                case 100:
                    pastry = "Pie";
                    break;
                default:
                    ingredients.push(ingredient + 3);
            }
            if (pastry != null) {
                produce.put(pastry, produce.get(pastry) + 1);
            }
        }
        String cookingResult = hasCookedAll(produce)
                ? "Great! You succeeded in cooking all the food!"
                : "What a pity! You didn't have enough materials to cook everything.";
        String liquidsResult = liquids.size() == 0
                ? "Liquids left: none"
                : "Liquids left: " + liquids.toString().replaceAll("[\\[\\]]", "");
        String ingredientsResult = ingredients.size() == 0
                ? "Ingredients left: none"
                : "Ingredients left: " + ingredients.toString().replaceAll("[\\[\\]]", "");
        ;

        System.out.println(cookingResult);
        System.out.println(liquidsResult);
        System.out.println(ingredientsResult);
        produce.forEach((k, v) -> System.out.println(k + ": " + v));

    }

    private static boolean hasCookedAll(Map<String, Integer> map) {
        for (Integer value : map.values()) {
            if (value == 0) {
                return false;
            }
        }
        return true;
    }

}
