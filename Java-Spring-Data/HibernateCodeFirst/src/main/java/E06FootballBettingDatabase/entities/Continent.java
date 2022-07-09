package E06FootballBettingDatabase.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "e06_continents")
public class Continent {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "continents")
    private Set<Country> countries = new HashSet<>();
}
