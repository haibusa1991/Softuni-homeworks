package automapper.entities.game;

import automapper.entities.Mapper;
import automapper.entities.user.User;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static automapper.ApplicationStrings.*;
import static automapper.entities.Utils.*;


@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final Validator validator;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, Validator validator) {
        this.gameRepository = gameRepository;
        this.validator = validator;
    }

    @Override
    public void saveToRepository(Game game) {
        this.gameRepository.save(game);
    }

    @Override
    public Game getGameByName(String gameName) {
        return this.gameRepository.getGameByTitle(gameName);

    }

    @Override
    public Game addGame(String gameTokens) {
        final int NUM_EXPECTED_TOKENS = 8;

        String[] tokens = gameTokens.split("\\|");


        if (tokens.length != NUM_EXPECTED_TOKENS) {
            throw new IllegalArgumentException(String.format(INCORRECT_NUMBER_OF_ARGUMENTS, NUM_EXPECTED_TOKENS, tokens.length));
        }

        String title;           //1
        BigDecimal price;       //2
        double size;            //3
        String trailerId;       //4
        String thumbnail;       //5
        String description;     //6
        LocalDate releaseDate;  //7

        try {
            title = tokens[1];
            price = BigDecimal.valueOf(Double.parseDouble(tokens[2]));
            size = Double.parseDouble(tokens[3]);
            trailerId = tokens[4];
            thumbnail = tokens[5];
            description = tokens[6];
            releaseDate = LocalDate.parse(tokens[7], DATE_TIME_FORMATTER);
        } catch (Exception e) {
            throw new IllegalArgumentException(GAME_MALFORMED_DATA);
        }

        Game game = new Game(title,
                trailerId,
                thumbnail,
                size,
                price,
                description,
                releaseDate);
        Set<ConstraintViolation<Game>> gameConstraintViolations = validator.validate(game);
        if (gameConstraintViolations.size() > 0) {
            throw new IllegalArgumentException(GAME_MALFORMED_DATA);
        }

        game.setTrailerYoutubeId(trimYoutubeUrl(game.getTrailerYoutubeId()));
        return gameRepository.save(game);
    }

    private String trimYoutubeUrl(String rawUrl) {
        if (rawUrl.length() == 11) {
            return rawUrl;
        }
        return rawUrl.split("&")[0].split("=")[1];
    }

    @Override
    public Game editGame(String editTokens) throws NoSuchFieldException, IllegalAccessException {
//        EditGame|1|price=80.00|size=12.0

        String[] tokens = editTokens.split("\\|");

        int gameId;
        try {
            gameId = Integer.parseInt(tokens[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException(GAME_MALFORMED_DATA);
        }

        Game game = gameRepository.getGameById(gameId);

        if (game == null) {
            throw new IllegalArgumentException(String.format(GAME_NO_SUCH_ID, gameId));
        }

        List<String> parameters = Arrays.stream(editTokens.split("\\|"))
                .skip(2)
                .collect(Collectors.toList());

        for (String parameter : parameters) {
            String fieldName = parameter.split("=")[0];
            String fieldValue = parameter.split("=")[1];

            Field f = Game.class.getDeclaredField(fieldName);

            if (f.getAnnotationsByType(Id.class).length > 0) {
                continue;
            }

            f.setAccessible(true);
            switch (f.getType().getName()) {
                case "int" -> f.setInt(game, Integer.parseInt(fieldValue));
                case "java.lang.String" -> f.set(game, fieldValue);
                case "double" -> f.setDouble(game, Double.parseDouble(fieldValue));
                case "java.math.BigDecimal" -> f.set(game, BigDecimal.valueOf(Double.parseDouble(fieldValue)));
                case "java.time.LocalDate" -> f.set(game, LocalDate.parse(fieldValue, DATE_TIME_FORMATTER));
            }
        }

        return this.gameRepository.save(game);
    }

    @Override
    public void deleteGame(String tokens) {
        int gameId;

        try {
            gameId = Integer.parseInt(tokens.split("\\|")[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException(GAME_MALFORMED_DATA);
        }

        if (gameRepository.countDistinctById(gameId) == 0) {
            throw new IllegalArgumentException(String.format(GAME_NO_SUCH_ID, gameId));
        }

        gameRepository.deleteById(gameId);
    }

    @Override
    public List<GamePriceTitleDTO> getAllGames() {
        List<String> games = gameRepository.getAllGames();
        List<GamePriceTitleDTO> dtos = new ArrayList<>();
        for (String game : games) {
            String[] tokens = game.split(",");
            String name = tokens[0];
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(tokens[1]));
            dtos.add(new GamePriceTitleDTO(name, price));
        }
        return dtos;
    }


    @Override
    public GameDetailDTO getDetailInfo(String input) {
        String gameTitle = input.split("\\|")[1];
        Object[] rawData;
        try {
            rawData = (Object[]) this.gameRepository.getDetails(gameTitle).get(0);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(GAME_NO_SUCH_TITLE, gameTitle));
        }

        String title = (String) rawData[0];
        BigDecimal price = (BigDecimal) rawData[1];
        String description = (String) rawData[2];
        LocalDate releaseDate = (LocalDate) rawData[3];

        return new GameDetailDTO(title, price, description, releaseDate);
    }

}
