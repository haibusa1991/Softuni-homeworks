package lecture02EncapsulationExcercise.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaTokens = scanner.nextLine().split(" ");
        Pizza pizza;
        try {
            pizza = new Pizza(pizzaTokens[1], Integer.parseInt(pizzaTokens[2]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughTokens = scanner.nextLine().split(" ");
        Dough dough;
        try {
            dough = new Dough(doughTokens[1], doughTokens[2], Double.parseDouble(doughTokens[3]));
            pizza.setDough(dough);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String topping = scanner.nextLine();
        while (!topping.equals("END")) {
            Topping currentTopping;
            String[] toppingTokens = topping.split(" ");
            try {
                currentTopping = new Topping(toppingTokens[1], Double.parseDouble(toppingTokens[2]));
                pizza.addTopping(currentTopping);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            topping = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(),pizza.getOverallCalories());

    }
}
