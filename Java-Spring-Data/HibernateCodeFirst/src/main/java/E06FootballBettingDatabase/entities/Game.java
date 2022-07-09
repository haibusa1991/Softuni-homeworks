package E06FootballBettingDatabase.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "games")
public class Game {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne (targetEntity = Team.class)
    private Team homeTeam;

    @ManyToOne (targetEntity = Team.class)
    private Team awayTeam;

    @Column(name = "home_goals_count")
    private int homeGoals;

    @Column(name = "away_goals_count")
    private int awayGoals;

    @Column(name = "game_time")
    private LocalDateTime gameTime;

    @Column(name = "home_team_win_rate")
    private double homeTeamWinRate;

    @Column(name = "away_team_win_rate")
    private double awayTeamWinRate;

    @Column(name = "draw_rate")
    private double drawRate;

    @ManyToOne(targetEntity = Round.class)
    @Enumerated(value = EnumType.STRING)
    private Round round;

    @ManyToOne(targetEntity = Competition.class)
    @Enumerated(value = EnumType.STRING)
    private Competition competition;

    @ManyToMany
    @JoinTable(name = "e06_bets_games",
    joinColumns = @JoinColumn(name = "game_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "bet_id",referencedColumnName = "id"))
    private Set<Bet> bets = new HashSet<>();

}
