package lecture04Interfaces.E06MilitaryElite;

public class Mission {
    private final String name;
    private final MissionStatus status;

    public Mission(String name, MissionStatus status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.name, this.status.getName());
    }
}
