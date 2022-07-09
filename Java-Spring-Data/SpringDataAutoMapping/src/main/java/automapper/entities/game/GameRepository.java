package automapper.entities.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    Game getGameByTitle(String title);

    Game getGameById(int id);

    @Transactional
    @Modifying
    void deleteById(int id);

    int countDistinctById(int id);

    @Query("""
            SELECT g.title,g.price
            FROM Game g
            """)
    List<String> getAllGames();

    @Query("""
            SELECT g.price
            FROM Game g
            WHERE g.title = :gameTitle
            """)
    BigDecimal getGamePrice(String gameTitle);

    @Query("""
            SELECT g.title,g.price,g.description,g.releaseDate
            FROM Game g
            WHERE g.title = :gameTitle
                        """)
    List<Object> getDetails(String gameTitle);

    boolean existsByTitle(String title);
}
