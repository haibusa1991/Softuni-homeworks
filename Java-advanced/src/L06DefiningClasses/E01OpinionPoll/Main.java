package L06DefiningClasses.E01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            people.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
        }
        people.stream()
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(e -> System.out.printf("%s - %d%n", e.getName(), e.getAge()));
    }
}
