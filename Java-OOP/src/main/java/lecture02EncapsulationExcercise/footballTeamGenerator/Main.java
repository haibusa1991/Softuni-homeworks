package lecture02EncapsulationExcercise.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");
        String command;
        while (!input[0].equals("END")) {
            command = input[0];
            String teamName = input[1];
            switch (command) {
                case "Team":
                    teams.add(new Team(teamName));
                    break;
                case "Add":
                    if (!teamExists(teamName)) {
                        printNonExistingTeam(teamName);
                        break;
                    }

                    Player p;
                    try {
                        p = new Player(input[2],
                                Integer.parseInt(input[3]),
                                Integer.parseInt(input[4]),
                                Integer.parseInt(input[5]),
                                Integer.parseInt(input[6]),
                                Integer.parseInt(input[7]));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    Team currentTeam = getTeam(teamName);
                    currentTeam.addPlayer(p);
                    break;
                case "Remove":
                    if (!teamExists(teamName)) {
                        printNonExistingTeam(teamName);
                        break;
                    }

                    currentTeam = getTeam(teamName);
                    boolean hasRemoved = currentTeam.removePlayer(input[2]);
                    if (!hasRemoved) {
                        System.out.printf("Player %s is not in %s team.%n", input[2], currentTeam.getName());
                    }
                    break;
                case "Rating":
                    if (!teamExists(teamName)) {
                        printNonExistingTeam(teamName);
                        break;
                    }
                    System.out.printf("%s - %d%n", getTeam(teamName).getName(),
                            (int) Math.round(getTeam(teamName).getRating()));
                    break;
            }
            input = scanner.nextLine().split(";");
        }
    }

    private static void printNonExistingTeam(String teamName) {
        System.out.println("Team " + teamName + " does not exist.");
    }

    private static Team getTeam(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }

    private static boolean teamExists(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }
}
