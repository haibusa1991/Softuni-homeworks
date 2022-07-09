package lecture02;

import java.util.Scanner;

public class ME06Pets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        int totalFood = Integer.parseInt(sc.nextLine());
        double dogFood = Double.parseDouble(sc.nextLine());
        double catFood = Double.parseDouble(sc.nextLine());
        double tortoiseFood = Double.parseDouble(sc.nextLine());

        double requiredDogFood = dogFood * days;
        double requiredCatFood = catFood * days;
        double requiredTortoiseFood = tortoiseFood * days / 1000;

        double requiredTotalFood = requiredDogFood + requiredCatFood + requiredTortoiseFood;

        if (totalFood >= requiredTotalFood) {
            System.out.printf("%d kilos of food left.", (int) Math.floor(totalFood - requiredTotalFood));
        } else {
            System.out.printf("%d more kilos of food are needed.", (int) Math.ceil(requiredTotalFood - totalFood));
        }
    }
}
