package lecture07;

import java.util.*;

public class ME01Ranking {
    public static void main(String[] args) {
        Map<String, String> contests = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String inputContests = scanner.nextLine();
        while (!inputContests.equals("end of contests")) {
            contests.put(inputContests.split(":")[0], inputContests.split(":")[1]);
            inputContests = scanner.nextLine();
        }
        Map<String, Map<String, Integer>> candidates = new LinkedHashMap<>();
        String inputCandidates = scanner.nextLine();
        while (!inputCandidates.equals("end of submissions")) {
            String contest = inputCandidates.split("=>")[0];
            String contestPassword = inputCandidates.split("=>")[1];
            String candidate = inputCandidates.split("=>")[2];
            int contestPoints = Integer.parseInt(inputCandidates.split("=>")[3]);
            if (contests.containsKey(contest) && contests.get(contest).equals(contestPassword)) {
                if (!candidates.containsKey(candidate)) {
                    Map<String, Integer> currentContest = new LinkedHashMap<>() {{
                        put(contest, contestPoints);
                    }};
                    candidates.put(candidate, currentContest);
                } else {
                    Map<String, Integer> contestsParticipated = candidates.get(candidate);
                    if (!contestsParticipated.containsKey(contest)) {
                        contestsParticipated.put(contest, contestPoints);
                    } else {
                        int currentContestPoints = contestsParticipated.get(contest);
                        if (currentContestPoints < contestPoints) {
                            contestsParticipated.put(contest, contestPoints);
                        }
                    }
                    candidates.put(candidate, contestsParticipated);
                }
            }
            inputCandidates = scanner.nextLine();
        }
        Map<String, Integer> candidatePoints = new HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> candidate : candidates.entrySet()) {
            Map<String, Integer> currentContest = candidate.getValue();
            int totalPoints = currentContest.values()
                    .stream()
                    .mapToInt(i -> i)
                    .sum();
            candidatePoints.put(candidate.getKey(), totalPoints);
        }
        candidatePoints.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .forEach(e -> System.out.printf("Best candidate is %s with total %d points.%n", e.getKey(), e.getValue()));
        System.out.println("Ranking:");
        candidates.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    System.out.println(e.getKey());
                    Map<String, Integer> currentContests = e.getValue();
                    currentContests.entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(w -> System.out.printf("#  %s -> %d%n", w.getKey(), w.getValue()));
                });
    }
}
