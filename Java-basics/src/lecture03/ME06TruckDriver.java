package lecture03;

import java.util.Scanner;

public class ME06TruckDriver {

    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        String season = scanner.nextLine();
        double kilometers=Double.parseDouble(scanner.nextLine());

        double pricePerKm = 1.45;

        switch (season) {
            case "Spring":
            case "Autumn":
                if (kilometers <= 5000) {
                    pricePerKm = 0.75;
                } else if (kilometers <= 10000) {
                    pricePerKm = 0.95;
                }
                break;
            case "Summer":
                if (kilometers<=5000){
                    pricePerKm=0.9;
                }else if (kilometers<=10000){
                    pricePerKm=1.1;
                }
                break;
            case "Winter":
                if (kilometers<=5000){
                    pricePerKm=1.05;
                }else if (kilometers<=10000){
                    pricePerKm=1.25;
                }
                break;
        }
        double earnings = kilometers*pricePerKm*4*0.9;
        System.out.printf("%.2f",earnings);
    }
}
