package L08IteratorsAndComparators.E06StrategyPattern;

import L08IteratorsAndComparators.Iterators.Person;
import L08IteratorsAndComparators.Iterators.PersonAgeComparator;
import L08IteratorsAndComparators.Iterators.PersonNameComparator;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Person> nameComp = new TreeSet<>(new PersonNameComparator());
        Set<Person> ageComp = new TreeSet<>(new PersonAgeComparator());

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] personData = scanner.nextLine().split(" ");
            Person currentPerson = new Person(personData[0], Integer.parseInt(personData[1]));
            nameComp.add(currentPerson);
            ageComp.add(currentPerson);
        }

        nameComp.forEach(e -> System.out.printf("%s %d%n", e.getName(), e.getAge()));
        ageComp.forEach(e -> System.out.printf("%s %d%n", e.getName(), e.getAge()));

    }
}
