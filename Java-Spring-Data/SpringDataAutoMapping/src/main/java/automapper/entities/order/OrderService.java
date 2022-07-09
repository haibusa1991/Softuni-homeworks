package automapper.entities.order;

import automapper.entities.user.User;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public interface OrderService {
    @Transactional
    void saveToRepository(Order order);

    void emptyCart();

    String addGameToCart(String tokens, User user);

    BigDecimal buyGames(User user);

    String removeFromCart(String tokens);
}
