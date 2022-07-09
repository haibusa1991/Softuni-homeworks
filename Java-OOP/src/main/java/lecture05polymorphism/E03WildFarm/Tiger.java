package lecture05polymorphism.E03WildFarm;

public class Tiger extends Feline {
    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    void eatFood(Food food) {
        if (food instanceof Vegetable) {
                throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        this.foodEaten += food.getQuantity();
    }
}
