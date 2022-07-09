package lecture04Interfaces.E06MilitaryElite;

import java.util.Collections;
import java.util.List;

public class Commando extends SpecialisedSoldierImpl {
    private final List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, Corps corps, List<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(System.lineSeparator())
                .append("Missions:");

        this.missions.forEach(e -> sb
                .append(System.lineSeparator())
                .append("  ")
                .append(e));

        return sb.toString();
    }

    public void addMission(Mission m) {
        this.missions.add(m);
    }

    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }
}
