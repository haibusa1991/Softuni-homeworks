package lecture02;

import java.util.Scanner;

public class ME05Firm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int requiredHours = Integer.parseInt(sc.nextLine());
        int availableDays = Integer.parseInt(sc.nextLine());
        int numOfEmployees = Integer.parseInt(sc.nextLine());

        int availableHours = (int) Math.floor ((availableDays * .9*8) + (availableDays*numOfEmployees*2));
        if (availableHours >= requiredHours) {
            System.out.printf("Yes!%d hours left.", availableHours-requiredHours);
        } else {
            System.out.printf("Not enough time!%d hours needed.",requiredHours-availableHours);
        }
    }
}
