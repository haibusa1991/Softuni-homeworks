package E06FootballBettingDatabase.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "players")
public class Player {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "squad_number")
    private int squadNumber;

    @ManyToOne(targetEntity = Team.class)
    private Team team;

    @ManyToOne(targetEntity = Position.class)
    private Position position;

    private boolean injured;

    @ManyToMany
    @JoinTable(
            name = "e06_players_games",
            joinColumns = @JoinColumn(name = "players", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "games", referencedColumnName = "id")
    )
    private Set<Game> games = new HashSet<>();
}
