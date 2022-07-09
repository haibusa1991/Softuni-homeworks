package L06DefiningClasses.E09CatLady;

public class Cymric extends Cat{

    public Cymric(String name, double characteristic) {
        super(name, characteristic);
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", name, characteristic);
    }
}
