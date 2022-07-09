package lecture02EncapsulationExcercise.pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private double flourMultiplier;
    private double bakingMultiplier;

    private final String wrongFlour = "Invalid type of dough.";


    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
                flourMultiplier = 1.5;
                break;
            case "Wholegrain":
                flourMultiplier = 1.0;
                break;
            default:
                throw new IllegalArgumentException(wrongFlour);
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                bakingMultiplier = 0.9;
                break;
            case "Chewy":
                bakingMultiplier = 1.1;
                break;
            case "Homemade":
                bakingMultiplier = 1.0;
                break;
            default:
                throw new IllegalArgumentException(wrongFlour);
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        return 2 * weight * flourMultiplier * bakingMultiplier;
    }
}


