package L03SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E13SrpskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("(?<singerName>.+) @(?<venue>.+) (?<ticketPrice>\\d+) (?<numTickets>\\d+)");
        Matcher matcher;
        while (!input.equals("End")) {
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singerName = matcher.group("singerName");
                String venue = matcher.group("venue");
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int numTickets = Integer.parseInt(matcher.group("numTickets"));

                venues.putIfAbsent(venue, new LinkedHashMap<>());
                Map<String, Integer> currentVenue = venues.get(venue);
                currentVenue.putIfAbsent(singerName, 0);
                currentVenue.put(singerName, currentVenue.get(singerName) + ticketPrice * numTickets);
                venues.put(venue, currentVenue);
            }
            input = reader.readLine();
        }

        venues.forEach((venue, singers) -> {
            System.out.println(venue);
            singers.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(e -> System.out.println("#  " + e.getKey() + " -> " + e.getValue()));
        });
    }
}
