package L06DefiningClasses.E07Google;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private Company company;
    private List<Pokemon> pokemon = new ArrayList<>();
    private List<Relative> parents = new ArrayList<>();
    private List<Relative> children = new ArrayList<>();
    private Car car;

    public Person(String name) {
        this.name = name;
    }

    public void setCompany(String name, String department, double salary) {
        company = new Company(name, department, salary);
    }

    public void addPokemon(String name, String type) {
        pokemon.add(new Pokemon(name, type));
    }

    public void addParent(String name, String birthday) {
        parents.add(new Relative(name, birthday));
    }

    public void addChild(String name, String birthday) {
        children.add(new Relative(name, birthday));
    }

    public void setCar(String model, int speed) {
        car = new Car(model, speed);
    }

    public void printAll() {
        System.out.println(name);
        System.out.println("Company:");
        System.out.print(company == null ? "" : company+"\n");
        System.out.println("Car:");
        System.out.print(car == null ? "" : car+"\n");
        System.out.println("Pokemon:");
        pokemon.forEach(System.out::println);
        System.out.println("Parents:");
        parents.forEach(System.out::println);
        System.out.println("Children:");
        children.forEach(System.out::println);
    }
}
