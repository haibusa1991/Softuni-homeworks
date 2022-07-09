package lecture02EncapsulationExcercise.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public boolean removePlayer(String playerName) {
        return players.removeIf(e -> e.getName().equals(playerName));
    }

    public double getRating() {

        return players.stream().mapToDouble(Player::overallSkillLevel).sum();
    }
}
