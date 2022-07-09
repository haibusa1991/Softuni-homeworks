package lecture01WorkingWithAbstraction.L04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");

        double price = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2].toUpperCase());
        Discount discount = tokens[3].equals("SecondVisit")
                ? Discount.SECOND_VISIT
                : Discount.valueOf(tokens[3].toUpperCase());

        System.out.println(PriceCalculator.getFinalPrice(price, days, season, discount));
    }
}
