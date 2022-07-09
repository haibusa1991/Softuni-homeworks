package lecture05polymorphism.E03WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    String makeSound() {
        return "Meowwww";
    }

    @Override
    void eatFood(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getClass().getSimpleName(),
                this.animalName,
                this.breed,
                df.format(animalWeight),
                this.livingRegion,
                this.foodEaten);
    }
}
