package lecture06.ME04TeamworkProjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> teams = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] currentTeamInput = scanner.nextLine().split("-");
            String teamName = currentTeamInput[1];
            String creatorName = currentTeamInput[0];
            //check if a team created by current creator is already created
            if (teams.stream().anyMatch(e -> e.getCreatorName().equals(creatorName))) {
                System.out.printf("%s cannot create another team!\n", creatorName);
                //check if a team with the same name is already created
            } else if (teams.stream().anyMatch(e -> e.getName().equals(teamName))) {
                System.out.printf("Team %s was already created!\n", teamName);
                //add a new team
            } else {
                teams.add(new Team(teamName, new TeamMember(creatorName)));
                System.out.printf("Team %s has been created by %s!\n", teamName, creatorName);
            }
        }

        String currentMemberInput = scanner.nextLine();
        while (!currentMemberInput.equals("end of assignment")) {
            String[] data = currentMemberInput.split("->");
            String teamName = data[1];
            String teammateName = data[0];
            //check if current team exists
            if (teams.stream().noneMatch(e -> e.getName().equals(teamName))) {
                System.out.printf("Team %s does not exist!\n", teamName);
                //check if current member is already on in a team
            } else if (teams.stream()
                    .anyMatch(e -> e.getOrderedMemberList()
                            .stream()
                            .anyMatch(m -> m.getName().equals(teammateName)))) {
                System.out.printf("Member %s cannot join team %s!\n", teammateName, teamName);
                //add new member to the required team
            } else {
                teams.stream()
                        .filter(e -> e.getName().equals(teamName))
                        .collect(Collectors.toList())
                        .get(0)
                        .addMember(new TeamMember(teammateName));
            }
            currentMemberInput = scanner.nextLine();
        }

        List<Team> validTeams = teams.stream()
                .filter(e -> e.getNumberOfMembers() >= 1)
                .sorted(Comparator.comparing(Team::getNumberOfMembers)
                        .reversed()
                        .thenComparing(Team::getName))
                .collect(Collectors.toList());
        List<Team> teamsToDisband = teams.stream()
                .filter(e -> e.getNumberOfMembers() == 0)
                .sorted(Comparator.comparing(Team::getName))
                .collect(Collectors.toList());

        for (Team team : validTeams) {
            System.out.println(team.getName());
            team.printOrderedMemberList();
        }
        System.out.println("Teams to disband:");
        for (Team team : teamsToDisband) {
            System.out.println(team.getName());
        }
    }

}
