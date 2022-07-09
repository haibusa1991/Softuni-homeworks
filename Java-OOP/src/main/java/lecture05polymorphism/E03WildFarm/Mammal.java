package lecture05polymorphism.E03WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    protected String livingRegion;

    public Mammal(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %d]",
                this.getClass().getSimpleName(),
                this.animalName,
                df.format(animalWeight),
                this.livingRegion,
                this.foodEaten);
    }
}



