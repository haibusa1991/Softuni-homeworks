package L08IteratorsAndComparators.E07EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            Person currentPerson = new Person(tokens[0], Integer.parseInt(tokens[1]));
            treeSet.add(currentPerson);
            hashSet.add(currentPerson);
        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());

    }
}
