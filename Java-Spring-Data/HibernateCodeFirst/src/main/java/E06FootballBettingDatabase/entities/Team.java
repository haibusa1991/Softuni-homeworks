package E06FootballBettingDatabase.entities;

import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "e06_teams")
public class Team {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    private String logo;

    @Size(min = 3, max = 3)
    private String initials;

    @ManyToOne(targetEntity = Color.class)
    private Color primaryColor;

    @ManyToOne(targetEntity = Color.class)
    private Color secondaryColor;

    @ManyToOne(targetEntity = Town.class)
    private Town town;

    @Column(nullable = false)
    private BigDecimal budget;
}
