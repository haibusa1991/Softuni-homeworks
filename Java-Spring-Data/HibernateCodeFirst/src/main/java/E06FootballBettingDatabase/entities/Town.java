package E06FootballBettingDatabase.entities;

import javax.persistence.*;

@Entity(name = "e06_towns")
public class Town {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = Country.class)
    private Country country;
}
