package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;

public class E10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] data = input.split(" ");
            String inputAction = data[0];
            String filter = data[1];
            String value = data[2];

            Predicate<String> startsWith = e -> e.startsWith(value);
            Predicate<String> endsWith = e -> e.endsWith(value);
            Predicate<String> length = e -> e.length() == Integer.parseInt(value);
            Supplier<Boolean> hasToRemove = () -> inputAction.equals("Remove");
            Supplier<List<String>> startsWithSupplier = () -> guests.stream().filter(startsWith).collect(Collectors.toList());
            Supplier<List<String>> endsWithSupplier = () -> guests.stream().filter(endsWith).collect(Collectors.toList());
            Supplier<List<String>> lengthSupplier = () -> guests.stream().filter(length).collect(Collectors.toList());

            boolean retVal;
            switch (filter) {
                case "StartsWith":
                    retVal = hasToRemove.get()
                            ? guests.removeIf(startsWith)
                            : guests.addAll(startsWithSupplier.get());
                    break;
                case "EndsWith":
                    retVal = hasToRemove.get()
                            ? guests.removeIf(endsWith)
                            : guests.addAll(endsWithSupplier.get());
                    break;
                case "Length":
                    retVal = hasToRemove.get()
                            ? guests.removeIf(length)
                            : guests.addAll(lengthSupplier.get());
                    break;
            }

            input = scanner.nextLine();
        }
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(guests.stream().sorted().collect(Collectors.joining(", ")));
            System.out.print(" are going to the party!");
        }

    }
}
