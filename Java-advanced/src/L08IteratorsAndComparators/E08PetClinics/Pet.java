package L08IteratorsAndComparators.E08PetClinics;

import java.net.SocketTimeoutException;

public class Pet {
    private final String name;
    private final int age;
    private final String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", name, age, kind);
    }
}
