package lecture01WorkingWithAbstraction.L04HotelReservation;

public class PriceCalculator {
    public static String getFinalPrice(double pricePerDay, int numDays, Season s, Discount d) {
        double val = pricePerDay * numDays * s.getMultiplier() * d.getDiscount();
        return String.format("%.2f", val);
    }
}
