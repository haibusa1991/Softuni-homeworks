package lecture02EncapsulationExcercise.pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    private double multiplier;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }


    public Topping(String toppingType) {
        this(toppingType, 0);
    }

    private void setToppingType(String topping) {
        switch (topping) {
            case "Meat":
                multiplier = 1.2;
                break;
            case "Veggies":
                multiplier = 0.8;
                break;
            case "Cheese":
                multiplier = 1.1;
                break;
            case "Sauce":
                multiplier = 0.9;
                break;
            default:
                throw new IllegalArgumentException("Cannot place " + topping + " on top of your pizza.");
        }
        toppingType = topping;
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * multiplier * weight;
    }

}
