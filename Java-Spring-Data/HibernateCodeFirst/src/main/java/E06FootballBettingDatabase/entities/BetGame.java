package E06FootballBettingDatabase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity(name = "bet_games")
public class BetGame {

    @Id
    private Game game;

    @Id
    private Bet bet;

    @Column(name = "result_prediction")
    private ResultPrediction resultPrediction;

}
