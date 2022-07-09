package lecture05polymorphism.E03WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    String makeSound() {
        return "Zs";
    }

    @Override
    void eatFood(Food food) {
        if (food instanceof Meat) {
                throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
            this.foodEaten += food.getQuantity();
        }
    }
