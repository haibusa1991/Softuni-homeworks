package L06DefiningClasses.E07Google;

public class Relative {
    public String name;
    public String birthday;

    @Override
    public String toString() {
        return String.format("%s %s", name, birthday);
    }

    public Relative(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
