package L03SetsAndMapsAdvanced;

import java.util.*;

public class E10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            Long population = Long.parseLong(data[2]);
            countries.putIfAbsent(country, new LinkedHashMap<>());
            Map<String, Long> cities = countries.get(country);
            cities.put(city, population);
            countries.put(country, cities);
            input = scanner.nextLine();
        }
        countries.entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(getTotalPopulation(e2.getValue()), getTotalPopulation(e1.getValue())))
                .forEach((e) -> {
                    System.out.println(e.getKey() + " (total population: " + getTotalPopulation(e.getValue()) + ")");
                    e.getValue()
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(k -> System.out.println("=>" + k.getKey() + ": " + k.getValue()));
                });
    }

    private static Long getTotalPopulation(Map<String, Long> cities) {
        Long sum = 0L;
        for (Map.Entry<String, Long> city : cities.entrySet()) {
            sum += city.getValue();
        }
        return sum;
    }
}
