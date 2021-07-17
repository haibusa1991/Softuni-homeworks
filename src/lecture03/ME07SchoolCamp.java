package lecture03;

import java.util.Scanner;

public class ME07SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String studentsGroup = scanner.nextLine();
        int numStudents = Integer.parseInt(scanner.nextLine());
        int numNights = Integer.parseInt(scanner.nextLine());

        double pricePerNight = 0;
        String sport = "";
        double discount = 0;

        switch (studentsGroup) {
            case "boys":
                switch (season) {
                    case "Winter":
                        pricePerNight = 9.6;
                        sport = "Judo";
                        break;
                    case "Spring":
                        pricePerNight = 7.2;
                        sport = "Tennis";
                        break;
                    case "Summer":
                        pricePerNight = 15;
                        sport = "Football";
                        break;
                }
                break;

            case "girls":
                switch (season) {
                    case "Winter":
                        pricePerNight = 9.6;
                        sport = "Gymnastics";
                        break;
                    case "Spring":
                        pricePerNight = 7.2;
                        sport = "Athletics";
                        break;
                    case "Summer":
                        pricePerNight = 15;
                        sport = "Volleyball";
                        break;
                }
                break;

            case "mixed":
                switch (season) {
                    case "Winter":
                        pricePerNight = 10;
                        sport = "Ski";
                        break;
                    case "Spring":
                        pricePerNight = 9.5;
                        sport = "Cycling";
                        break;
                    case "Summer":
                        pricePerNight = 20;
                        sport = "Swimming";
                        break;
                }
                break;
        }

        if (numStudents >= 10 && numStudents<20 ) {
            discount = 0.05;
        } else if (numStudents>=20 && numStudents < 50) {
            discount = 0.15;
        } else if (numStudents >= 50) {
            discount = 0.5;
        }
        double finalPrice = pricePerNight * numNights * numStudents * (1 - discount);
        System.out.printf("%s %.2f lv.", sport, finalPrice);
    }
}
