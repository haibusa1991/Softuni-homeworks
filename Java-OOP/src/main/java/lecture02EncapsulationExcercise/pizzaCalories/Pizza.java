package lecture02EncapsulationExcercise.pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int maxToppingCount;
    private final String toppingsError = "Number of toppings should be in range [0..10].";

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }


    private void setName(String name) {
        if (name.trim().length() < 1 || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings > 10) {
            throw new IllegalArgumentException(toppingsError);
        }
        this.toppings = new ArrayList<>();
        maxToppingCount = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping t) {
        if (toppings.size() == maxToppingCount) {
            throw new IllegalArgumentException(toppingsError);
        }
        toppings.add(t);
    }

    public double getOverallCalories() {
        double calories = 0;
        calories += dough.calculateCalories();
        for (Topping topping : toppings) {
            calories += topping.calculateCalories();
        }
        return calories;
    }
}
