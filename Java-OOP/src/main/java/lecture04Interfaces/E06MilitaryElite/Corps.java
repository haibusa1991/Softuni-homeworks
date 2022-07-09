package lecture04Interfaces.E06MilitaryElite;

public enum Corps {
    AIRFORCES("Airforces"),
    MARINES("Marines");

    private String name;

    Corps(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
