package lecture06.E03OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        int numPeople = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numPeople; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            people.add(new Person(input[0], Integer.parseInt(input[1])));
        }

        people = people.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());
        people.sort(Comparator.comparing(Person::getName));

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
