package lecture01WorkingWithAbstraction.E06GreedyTimes;

public enum Type {
    GOLD("Gold"),
    GEM("Gem"),
    CASH("Cash");

    private final String name;

    public String getName() {
        return name;
    }

    Type(String name) {
        this.name = name;
    }
}
