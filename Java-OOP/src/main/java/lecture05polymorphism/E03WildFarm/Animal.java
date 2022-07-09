package lecture05polymorphism.E03WildFarm;

public abstract class Animal {

    protected String animalName;
    protected double animalWeight;
    protected int foodEaten;

    public Animal( String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    abstract String makeSound();

    abstract void eatFood(Food food);

}
