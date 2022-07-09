package lecture01;

import java.util.Scanner;

public class E09PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numStudents = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double lightsaberBudget = Math.ceil(numStudents * 1.1) * lightsaberPrice;
        double beltBudget = (numStudents - (numStudents / 6)) * beltPrice;
        double requiredBudget = lightsaberBudget + robePrice * numStudents + beltBudget;

        if (requiredBudget <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", requiredBudget);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", requiredBudget - budget);
        }

    }
}
