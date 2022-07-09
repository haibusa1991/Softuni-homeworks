package lecture02;

import java.util.Scanner;

public class ME09FuelTank2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fuelType = sc.nextLine();
        double fuelAmount = Double.parseDouble(sc.nextLine());
        String discountCardYesNo = sc.nextLine();

        boolean hasDiscountCard = false;
        double finalPrice = 0;

        double gasolinePrice = 2.22;
        double dieselPrice = 2.33;
        double gasPrice = 0.93;

        if (discountCardYesNo.equals("Yes")) {
            hasDiscountCard = true;
        }

        if (fuelType.equals("Gasoline")) {
            if (hasDiscountCard) {
                gasolinePrice -= 0.18;
            }
            finalPrice = fuelAmount * gasolinePrice;

        } else if (fuelType.equals("Diesel")) {
            if (hasDiscountCard) {
                dieselPrice -= 0.12;
            }
            finalPrice = fuelAmount * dieselPrice;

        } else if (fuelType.equals("Gas")) {
            if (hasDiscountCard) {
                gasPrice -= 0.08;
            }
            finalPrice = fuelAmount * gasPrice;
        }

        if (fuelAmount < 20) {
            //empty on purpose
        } else if (fuelAmount <= 25) {
            finalPrice *= .92;
        } else if (fuelAmount > 25) {
            finalPrice *= .9;
        }
        System.out.printf("%.2f lv.",finalPrice);
    }
}
