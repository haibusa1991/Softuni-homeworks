package E06FootballBettingDatabase.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "bets")
public class Bet {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private BigDecimal bet;

    @Column(nullable = false)
    private LocalDateTime betTime;

    @Transient //totally is transient
    private User user;

}
