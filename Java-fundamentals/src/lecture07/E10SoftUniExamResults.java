package lecture07;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> pointsMap = new HashMap<>();
        Map<String, Integer> submissionsMap = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            if (!input.contains("banned")) {
                String username = input.split("-")[0];
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);
                if (pointsMap.containsKey(username) && pointsMap.get(username) < points) {
                    pointsMap.put(username, points);
                } else {
                    pointsMap.putIfAbsent(username, points);
                }

                if (submissionsMap.containsKey(language)) {
                    submissionsMap.put(language, submissionsMap.get(language) + 1);
                } else {
                    submissionsMap.putIfAbsent(language, 1);
                }
            } else {
                pointsMap.remove(input.split("-")[0]);
            }
            input = scanner.nextLine();
        }

        System.out.println("Results:");
        pointsMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s | %d\n", e.getKey(), e.getValue()));

        System.out.println("Submissions:");
        submissionsMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s - %d\n", e.getKey(), e.getValue()));
    }
}
