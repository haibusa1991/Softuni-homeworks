package L08IteratorsAndComparators.E07EqualityLogic;

public class Person implements Comparable<Person> {
    private final String name;
    private final int age;
    private final String town;


    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public Person(String name, int age) {
        this(name, age, "");
    }

    @Override
    public int compareTo(Person other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = Integer.compare(this.age, other.age);
        }
        if (result == 0) {
            result = this.town.compareTo(other.town);
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() / this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if (Person.class != obj.getClass()) {
            return false;
        }
        Person p = (Person) obj;
        return this.name.equals(p.getName()) && this.age == p.getAge();
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}


