package lecture06.ME04TeamworkProjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Team {
    private String name;
    private List<TeamMember> members = new ArrayList<>();

    public Team(String name, TeamMember creator) {
        this.name = name;
        creator.setRole("creator");
        members.add(creator);
    }

    public void addMember(TeamMember member) {
        members.add(member);
    }

    public List<TeamMember> getOrderedMemberList() {
        members.sort(Comparator.comparing(TeamMember::getName));
        return members;
    }

    public void printOrderedMemberList() {
        members.sort(Comparator.comparing(TeamMember::getName));
        members.stream()
                .filter(e -> e.getRole().equals("creator"))
                .forEach(e -> System.out.println("- " + e.getName()));
        members.stream()
                .filter(e -> e.getRole().equals("member"))
                .forEach(e -> System.out.println("-- " + e.getName()));

    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getCreatorName() {
        return members.stream()
                .filter(e -> e.getRole().equals("creator"))
                .collect(Collectors.toList())
                .get(0)
                .getName();
    }

    public int getNumberOfMembers() {
        return members.size() - 1;
    }
}
