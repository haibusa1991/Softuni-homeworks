package lecture04Interfaces.E06MilitaryElite;

public abstract class SpecialisedSoldierImpl extends SoldierImpl implements Salaried {
    double salary;
    private final Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName);
        this.salary = salary;
        this.corps = corps;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Salary: %.2f", this.salary) + String.format("%nCorps: %s", corps.getName());
    }
}
