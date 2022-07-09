package L06DefiningClasses.E09CatLady;

public abstract class Cat {
    protected final String name;
    protected final double characteristic;

    public Cat(String name, double characteristic) {
        this.name = name;
        this.characteristic = characteristic;
    }

    public String getName() {
        return name;
    }
}
