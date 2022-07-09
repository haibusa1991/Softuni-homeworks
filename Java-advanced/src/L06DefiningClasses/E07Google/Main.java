package L06DefiningClasses.E07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String personName = tokens[0];
            String info = tokens[1];
            people.putIfAbsent(personName, new Person(personName));
            Person currentPerson = people.get(personName);
            switch (info) {
                case "company":
                    currentPerson.setCompany(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    break;
                case "pokemon":
                    currentPerson.addPokemon(tokens[2], tokens[3]);
                    break;
                case "parents":
                    currentPerson.addParent(tokens[2], tokens[3]);
                    break;
                case "children":
                    currentPerson.addChild(tokens[2], tokens[3]);
                    break;
                case "car":
                    currentPerson.setCar(tokens[2], Integer.parseInt(tokens[3]));
                    break;
            }
            input = scanner.nextLine();
        }
        people.get(scanner.nextLine()).printAll();
    }
}
