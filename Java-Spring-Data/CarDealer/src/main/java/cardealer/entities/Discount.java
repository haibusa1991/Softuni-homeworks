package cardealer.entities;

public enum Discount {
    ZERO(0),
    FIVE(0.95),
    TEN(0.9),
    FIFTEEN(0.85),
    TWENTY(0.8),
    THIRTY(0.7),
    FORTY(0.6),
    FIFTY(0.5);

    private final double discountMultiplier;

    Discount(double discountMultiplier) {
        this.discountMultiplier = discountMultiplier;
    }

    public double getDiscountMultiplier() {
        return discountMultiplier;
    }
}
