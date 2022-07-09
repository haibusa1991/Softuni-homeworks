package L03SetsAndMapsAdvanced;

import java.util.*;

public class L07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> countries = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String continent = data[0];
            String country = data[1];
            String city = data[2];
            countries.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> currentCountry = countries.get(continent);
            currentCountry.putIfAbsent(country, new ArrayList<>());
            List<String> cities = currentCountry.get(country);
            cities.add(city);
            currentCountry.put(country, cities);
            countries.put(continent, currentCountry);
        }

        countries.forEach((continent, country) -> {
            System.out.println(continent + ":");
            country.forEach((currentCountry, cities) -> {
                System.out.print("  " + currentCountry + " -> ");
                System.out.println(String.join(", ", cities));
            });
        });
    }
}
