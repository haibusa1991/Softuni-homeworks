package lecture01WorkingWithAbstraction.E06GreedyTimes;

public class Treasure {
    private final Type type;
    private int amount;
    private final String name;

    public Treasure(Type type, int amount, String name) {
        this.type = type;
        this.amount = amount;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }
}
