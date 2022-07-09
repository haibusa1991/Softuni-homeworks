package L08IteratorsAndComparators.E05ComparingObjects;

import L08IteratorsAndComparators.Iterators.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            people.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            input = scanner.nextLine();
        }
        Person targetPerson = people.get(Integer.parseInt(scanner.nextLine())-1);
        people.remove(targetPerson);
        int samePeople = 0;
        for (Person person : people) {
            if (targetPerson.compareTo(person) == 0) {
                samePeople++;
            }
        }
        if (samePeople == 0) {
            System.out.println("No matches");
            return;
        }
        samePeople++;
        int totalPeople = people.size() + 1;
        System.out.printf("%d %d %d", samePeople, totalPeople-samePeople,totalPeople);

    }
}
