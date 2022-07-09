package lecture07;

import java.util.*;

public class ME03MobaChallenger {
    static Map<String, Map<String, Integer>> players = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                addPlayer(input);
            } else {
                duelPlayers(input);
            }
            input = scanner.nextLine();
        }
        printPlayers();
    }


    private static void addPlayer(String input) {
        String playerName = input.split(" -> ")[0];
        String position = input.split(" -> ")[1];
        int skillPoints = Integer.parseInt(input.split(" -> ")[2]);

        players.putIfAbsent(playerName, new HashMap<>() {{
            put(position, skillPoints);
        }});

        Map<String, Integer> positions = players.get(playerName);
        positions.putIfAbsent(position, skillPoints);
        if (positions.containsKey(position)
                && positions.get(position) < skillPoints) {
            positions.put(position, skillPoints);
        }
    }

    private static void duelPlayers(String input) {
        String player1 = input.split(" vs ")[0];
        String player2 = input.split(" vs ")[1];

        if (!players.containsKey(player1) || !players.containsKey(player2)) {
            return;
        }

        if (canDuel(player1, player2)) {
            if (getTotalPoints(player1) > getTotalPoints(player2)) {
                players.remove(player2);
            } else if (getTotalPoints(player1) < getTotalPoints(player2)) {
                players.remove(player1);
            }
        }
    }

    private static boolean canDuel(String player1, String player2) {
        List<String> player1Skills = new ArrayList<>(players.get(player1).keySet());
        List<String> player2Skills = new ArrayList<>(players.get(player2).keySet());
        for (String skill : player1Skills) {
            if (player2Skills.contains(skill)) {
                return true;
            }
        }
        return false;
    }

    private static int getTotalPoints(String player) {
        return players.get(player)
                .values()
                .stream()
                .mapToInt(e -> e)
                .sum();
    }

    private static void printPlayers() {

        Map<String, Integer> skills = new HashMap<>();

        for (Map.Entry<String,Map<String,Integer>> currentPlayer : players.entrySet()){
            skills.put(currentPlayer.getKey(),getTotalPoints(currentPlayer.getKey()));
        }

        skills.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e->{
                    System.out.printf("%s: %d skill%n",e.getKey(),e.getValue());
                    Map<String,Integer> stats = players.get(e.getKey());
                    stats.entrySet()
                            .stream()
                            .sorted(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder())
                            .thenComparing(Map.Entry.comparingByKey()))
                            .forEach(w-> System.out.printf("- %s <::> %d%n",w.getKey(),w.getValue()));
                });


    }
}


