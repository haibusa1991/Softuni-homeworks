package E06FootballBettingDatabase.entities;

import jakarta.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "e06_positions")
public class Position {
    @Id
    @Size(min = 2, max = 2)
    private String id;

    @Column(nullable = false)
    private String description;
}
