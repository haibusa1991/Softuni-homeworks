package automapper.entities.order;

import automapper.entities.game.Game;
import automapper.entities.game.GameService;
import automapper.entities.user.User;
import automapper.entities.user.UserRepository;
import automapper.entities.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static automapper.ApplicationStrings.*;

@Service
public class OrderServiceImpl implements OrderService {
    private Set<Game> cart;
    private final OrderRepository orderRepository;
    private final GameService gameService;
    private final UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, GameService gameService, UserService userService, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.gameService = gameService;
        this.userRepository = userRepository;
        this.cart = new HashSet<>();
    }

    @Override
    public void saveToRepository(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public void emptyCart() {
        this.cart = new HashSet<>();
    }

    @Override
    public String addGameToCart(String tokens, User user) {
        String gameTitle = tokens.split("\\|")[1];
        Game game = gameService.getGameByName(gameTitle);

        if (game == null) {
            throw new IllegalArgumentException(String.format(GAME_NO_SUCH_TITLE, gameTitle));
        }

        if (cart.contains(game)) {
            throw new IllegalArgumentException(GAME_ALREADY_IN_CART);
        }

        if (user.getGames().contains(game)) {
            throw new IllegalArgumentException(String.format(GAME_ALREADY_OWNED, user.getEmail(), game.getTitle()));
        }

        cart.add(game);
        return String.format(GAME_ADDED_SUCCESSFULLY,gameTitle);
    }

    @Override
    public BigDecimal buyGames(User user) {

        if (this.cart.isEmpty()) {
            throw new IllegalArgumentException(CART_IS_EMPTY);
        }

        Set<Game> games = new HashSet<>(user.getGames());
        BigDecimal totalCost = BigDecimal.ZERO;

        for (Game game : cart) {
            totalCost = totalCost.add(game.getPrice());
            games.add(game);
        }

        user.setGames(games);

        Order order = new Order(user);
        order.setContents(cart);

        userRepository.save(user);
        orderRepository.save(order);

        emptyCart();
        return totalCost;
    }

    @Override
    public String removeFromCart(String tokens) {
        String gameTitle = tokens.split("\\|")[1];

        Game game = null;

        for (Game g : cart) {
            if (g.getTitle().equals(gameTitle)) {
                game = g;
            }
        }

        if (game == null) {
            throw new IllegalArgumentException(String.format(GAME_NOT_IN_CART, gameTitle));
        }

        cart.remove(game);
        return String.format(GAME_REMOVED_FROM_CART,gameTitle);
    }
}
