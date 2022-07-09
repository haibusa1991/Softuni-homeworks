package E06FootballBettingDatabase.entities;

import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "e06_countries")
public class Country {

    @Id
    @Size(min = 3, max = 3)
    private String id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "e06_countries_continents",
            joinColumns = @JoinColumn(name = "country", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "continent", referencedColumnName = "id")
    )
    private Set<Continent> continents;

    @OneToMany(targetEntity = Town.class)
    private Set<Town> towns = new HashSet<>();

    private boolean addTown(Town town) {
        return this.towns.add(town);
    }

    private boolean removeTown(Town town) {
        return this.towns.remove(town);
    }

}
