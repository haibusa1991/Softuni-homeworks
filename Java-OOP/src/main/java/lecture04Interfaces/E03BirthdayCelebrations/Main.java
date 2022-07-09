package lecture04Interfaces.E03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            Birthable birthable=null;
            if (tokens.length == 3 && tokens[0].equals("Pet")) {
                birthable = new Pet(tokens[1], tokens[2]);
            } else if (tokens.length == 5) {
                birthable = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
            }
            if (birthable != null) {
                birthables.add(birthable);
            }
            input = scanner.nextLine();
        }

        String yearBorn = scanner.nextLine();
        birthables.stream().filter(e -> e.getBirthDate().endsWith(yearBorn)).forEach(e -> System.out.println(e.getBirthDate()));
    }
}
