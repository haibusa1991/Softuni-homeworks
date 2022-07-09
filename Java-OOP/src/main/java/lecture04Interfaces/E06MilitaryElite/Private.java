package lecture04Interfaces.E06MilitaryElite;

public class Private extends SoldierImpl implements Salaried {
    private final double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Salary: %.2f", this.salary);
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
