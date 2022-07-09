package L03SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class L02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String guestListInput = scanner.nextLine();
        Set<String> guestList = new TreeSet<>();
        while (!guestListInput.equals("PARTY")) {
            guestList.add(guestListInput);
            guestListInput = scanner.nextLine();
        }
        String guest = scanner.nextLine();
        while (!guest.equals("END")) {
            guestList.remove(guest);
            guest = scanner.nextLine();
        }
        System.out.println(guestList.size());
        guestList.forEach(System.out::println);
    }
}
