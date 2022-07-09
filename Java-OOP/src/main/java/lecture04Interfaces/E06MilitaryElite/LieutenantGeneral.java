package lecture04Interfaces.E06MilitaryElite;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneral extends SoldierImpl implements Salaried {
    private final double salary;
    private final List<Private> privates;

    public LieutenantGeneral(int id, String firstName, String lastName, double salary, List<Private> privates) {
        super(id, firstName, lastName);
        this.salary = salary;
        this.privates = new ArrayList<>();
        this.privates.addAll(privates);
    }

    public void addPrivate(Private p) {
        privates.add(p);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format(" Salary: %.2f%n", this.salary))
                .append("Privates:")
                .append(System.lineSeparator());

        privates.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getId(), e1.getId()))
                .forEach(e -> sb
                        .append("  ")
                        .append(e)
                        .append(System.lineSeparator()));
        return sb.toString().trim();
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
