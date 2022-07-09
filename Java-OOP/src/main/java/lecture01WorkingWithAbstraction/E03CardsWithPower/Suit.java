package lecture01WorkingWithAbstraction.E03CardsWithPower;

public enum Suit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private final int power;

    public int getPower() {
        return power;
    }

    Suit(int power) {
        this.power = power;
    }
}
