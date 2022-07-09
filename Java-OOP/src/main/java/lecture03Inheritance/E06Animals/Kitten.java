package lecture03Inheritance.E06Animals;

public class Kitten extends Cat{
    private static final String GENDER="Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    public String produceSound() {
        return "Meow";
    }
}
