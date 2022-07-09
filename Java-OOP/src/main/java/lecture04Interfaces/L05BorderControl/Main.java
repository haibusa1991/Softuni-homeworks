package lecture04Interfaces.L05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> ids = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            Identifiable current;

            String[] tokens = input.split(" ");
            if (tokens.length == 2) {
                current = new Robot(tokens[0], tokens[1]);
            } else {
                current = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }

            ids.add(current);

            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();
        ids.stream().filter(e -> e.getId().endsWith(fakeId)).forEach(e -> System.out.println(e.getId()));
    }
}
