package E06FootballBettingDatabase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "e06_competition_types")
public class CompetitionTypes {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    public CompetitionTypes() {
    }

    public CompetitionTypes(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
