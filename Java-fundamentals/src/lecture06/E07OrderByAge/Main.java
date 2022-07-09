package lecture06.E07OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            people.add(new Person(data[0], data[1], Integer.parseInt(data[2])));
            input = scanner.nextLine();
        }
        people.sort(Comparator.comparing(Person::getAge));
        people.forEach(System.out::println);
    }
}
