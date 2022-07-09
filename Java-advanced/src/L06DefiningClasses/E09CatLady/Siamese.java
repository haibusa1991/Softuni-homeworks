package L06DefiningClasses.E09CatLady;

public class Siamese extends Cat{

    public Siamese(String name, double characteristic) {
        super(name, characteristic);
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", name, characteristic);
    }
}
