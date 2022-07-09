package lecture03;

import java.util.Scanner;

public class E07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int numDay = Integer.parseInt(scanner.nextLine());

        double studioPrice = 76;
        double apartmentPrice = 77;

        double studioDiscount = 0;
        double apartmentDiscount = 0;

        switch (month) {
            case "May":
            case "October":
                studioPrice = 50;
                apartmentPrice = 65;
                if (numDay > 14) {
                    studioDiscount = 0.3;
                } else if (numDay > 7) {
                    studioDiscount = 0.05;
                }
                break;
            case "June":
            case "September":
                studioPrice = 75.2;
                apartmentPrice = 68.7;
                if (numDay > 14) {
                    studioDiscount = 0.2;
                }
                break;
        }

        if (numDay > 14) {
            apartmentDiscount = 0.1;
        }

        double finalStudioPrice = studioPrice * numDay * (1 - studioDiscount);
        double finalApartmentPrice = apartmentPrice * numDay * (1 - apartmentDiscount);

        System.out.printf("Apartment: %.2f lv.\nStudio: %.2f lv.", finalApartmentPrice, finalStudioPrice);

    }
}

