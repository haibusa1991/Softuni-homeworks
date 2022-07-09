package lecture04Interfaces.E06MilitaryElite;

import java.util.Collections;
import java.util.List;

public class Engineer extends SpecialisedSoldierImpl {
    private final List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, Corps corps, List<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(System.lineSeparator())
                .append("Repairs:");

        repairs.forEach(e -> sb
                .append(System.lineSeparator())
                .append("  ")
                .append(e));

        return sb.toString();
    }
}
