package E06FootballBettingDatabase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity(name = "e06_player_statistics")
public class PlayerStatistics {

    @Id
    private Game game;

    @Id
    private Player player;

    @Column(name = "goals_count")
    private int numGoals;

    @Column(name = "assists_count")
    private int numAssists;

    @Column(name = "minutes_played")
    private int numMinutesPlayed;



}
