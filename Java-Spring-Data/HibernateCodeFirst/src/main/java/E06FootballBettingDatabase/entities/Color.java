package E06FootballBettingDatabase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "e06_colors")
public class Color {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    public Color() {
    }

    public Color(String name) {
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
