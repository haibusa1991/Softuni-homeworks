package lecture02;

import java.util.Scanner;

public class ME08FuelTank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fuelType = sc.nextLine();
        double availableFuel = Double.parseDouble(sc.nextLine());
        if (fuelType.equals("Diesel")) {
            if (availableFuel >= 25) {
                System.out.println("You have enough diesel.");
            } else {
                System.out.println("Fill your tank with diesel!");
            }
        }else if (fuelType.equals("Gasoline")) {
            if (availableFuel >= 25) {
                System.out.println("You have enough gasoline.");
            } else {
                System.out.println("Fill your tank with gasoline!");
            }
        } else if (fuelType.equals("Gas")) {
            if (availableFuel >= 25) {
                System.out.println("You have enough gas.");
            } else {
                System.out.println("Fill your tank with gas!");
            }
        } else {
            System.out.println("Invalid fuel!");
        }
    }
}
