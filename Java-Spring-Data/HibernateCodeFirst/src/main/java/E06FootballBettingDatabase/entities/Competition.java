package E06FootballBettingDatabase.entities;

import javax.persistence.*;

@Entity(name = "e06_competitions")
public class Competition {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Competitions type;
}
