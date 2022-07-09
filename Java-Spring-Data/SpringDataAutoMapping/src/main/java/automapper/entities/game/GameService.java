package automapper.entities.game;

import automapper.entities.user.User;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.List;

public interface GameService {
    void saveToRepository(Game game);

    Game getGameByName(String gameName);

    Game addGame(String game) throws MalformedURLException;

    Game editGame(String editTokens) throws NoSuchFieldException, IllegalAccessException;

    void deleteGame(String tokens);

    List<GamePriceTitleDTO> getAllGames();

    GameDetailDTO getDetailInfo(String input);

}
