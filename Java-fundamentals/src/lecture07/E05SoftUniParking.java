package lecture07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> users = new LinkedHashMap<>();
        int numUsers = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numUsers; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String name = input[1];

            if (command.equals("register")) {
                String licensePlate = input[2];
                if (users.containsKey(name)) {
                    System.out.println("ERROR: already registered with plate number " + users.get(name));
                } else {
                    users.put(name, licensePlate);
                    System.out.println(name + " registered " + licensePlate + " successfully");
                }
            } else {
                if (users.containsKey(name)) {
                    users.remove(name);
                    System.out.println(name + " unregistered successfully");
                } else {
                    System.out.println("ERROR: user " + name + " not found");
                }
            }
        }
        users.forEach((e1, e2) -> System.out.println(e1 + " => " + e2));
    }
}
