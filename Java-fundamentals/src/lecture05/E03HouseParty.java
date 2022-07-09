package lecture05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = new ArrayList<>();

        int numInput = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numInput; i++) {
            String[] currentInput = scanner.nextLine().split(" ");
            String guestName = currentInput[0];

            if (currentInput[2].equalsIgnoreCase("not")) {
                if (!guests.contains(guestName)) {
                    System.out.println(guestName + " is not in the list!");
                } else {
                    guests.remove(guestName);
                }
            } else {
                if (guests.contains(guestName)) {
                    System.out.println(guestName + " is already in the list!");
                } else {
                    guests.add(guestName);
                }
            }
        }
        System.out.println(guests.toString().replaceAll(", ", "\n").replaceAll("[\\[\\]]", ""));
    }
}
