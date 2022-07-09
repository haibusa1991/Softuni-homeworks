package lecture04Interfaces.E06MilitaryElite;

public enum MissionStatus {
    FINISHED("finished"),
    IN_PROGRESS("inProgress");

    private final String name;

    MissionStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
