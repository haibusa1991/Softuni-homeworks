package L06DefiningClasses.E09CatLady;

public class StreetExtraordinaire extends Cat{

    public StreetExtraordinaire(String name, double characteristic) {
        super(name, characteristic);
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", name, characteristic);
    }
}
