package E06FootballBettingDatabase.entities;

import javax.persistence.*;

@Entity(name = "e06_rounds")
public class Round {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Rounds name;

}
