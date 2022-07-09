package L06DefiningClasses.E07Google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {

        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", name, department, salary);
    }
}
