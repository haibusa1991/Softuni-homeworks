package lecture05polymorphism.E03WildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalName, Double animalWeight, String liningRegion) {
        super(animalName, animalWeight, liningRegion);
    }

    @Override
    String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    void eatFood(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        this.foodEaten += food.getQuantity();
    }
}
