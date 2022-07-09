package lecture07;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ME02Judge {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("no more time")) {
            String contest = input.split(" -> ")[1];
            String user = input.split(" -> ")[0];
            int points = Integer.parseInt(input.split(" -> ")[2]);

            if (!contests.containsKey(contest)) {
                Map<String, Integer> currentParticipants = new HashMap<>() {{
                    put(user, points);
                }};
                contests.put(contest, currentParticipants);
            } else {
                Map<String, Integer> currentParticipants = contests.get(contest);
                currentParticipants.putIfAbsent(user, points);
                if (points > currentParticipants.get(user)) {
                    currentParticipants.put(user, points);
                }
            }
            input = scanner.nextLine();
        }
        AtomicInteger x = new AtomicInteger(0);
        contests.entrySet()
                .stream()
                .peek(n -> x.lazySet(0))
                .forEach(e -> {
                    System.out.printf("%s: %d participants%n", e.getKey(), e.getValue().keySet().size());
                    Map<String, Integer> currentContestants = e.getValue();
                    currentContestants.entrySet()
                            .stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                            .forEach(w -> System.out.printf("%d. %s <::> %d%n", x.incrementAndGet(), w.getKey(), w.getValue()));
                });
        System.out.println("Individual standings:");
        Map<String, Integer> standings = new HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> participant : contests.entrySet()) {
            Map<String, Integer> currentParticipant = participant.getValue();
            currentParticipant.entrySet()
                    .forEach(e -> {
                        if (!standings.containsKey(e.getKey())) {
                            standings.put(e.getKey(), e.getValue());
                        } else {
                            standings.put(e.getKey(), standings.get(e.getKey()) + e.getValue());
                        }
                    });
        }
        x.lazySet(0);
        standings.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%d. %s -> %d%n", x.incrementAndGet(), e.getKey(), e.getValue()));
    }
}
