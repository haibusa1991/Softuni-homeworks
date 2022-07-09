package L05FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        Map<String, Predicate<String>> activeFilters = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] tokens = input.split(";");
            String action = tokens[0];
            String filter = tokens[1];
            String value = tokens[2];
            String filterName = filter + value;

            if (action.equals("Add filter")) {
                switch (filter) {
                    case "Starts with":
                        activeFilters.put(filterName, p -> !p.startsWith(value));
                        break;
                    case "Ends with":
                        activeFilters.put(filterName, p -> !p.endsWith(value));
                        break;
                    case "Length":
                        activeFilters.put(filterName, p -> p.length() != Integer.parseInt(value));
                        break;
                    case "Contains":
                        activeFilters.put(filterName, p -> !p.contains(value));
                        break;
                }
            } else {
                activeFilters.remove(filterName);
            }
            input = scanner.nextLine();
        }

        Predicate<String> finalFilter = x -> true;
        for (Map.Entry<String, Predicate<String>> currentFilter : activeFilters.entrySet()) {
            finalFilter = finalFilter.and(currentFilter.getValue());
        }
        System.out.println(guests.stream().filter(finalFilter).collect(Collectors.joining(" ")));
    }
}