package lecture04Interfaces.E06MilitaryElite;

public class Repair {
    private final String name;
    private final int hours;

    public Repair(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %s", this.name, this.hours);
    }
}
