package E06FootballBettingDatabase.entities;

import javax.persistence.*;

@Entity(name = "result_predictions")
public class ResultPrediction {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ResultPredictions prediction;
}
