package automapper;

import automapper.entities.exceptions.EmailOrPasswordWrong;
import automapper.entities.game.Game;
import automapper.entities.game.GameService;
import automapper.entities.game.GameTitleDTO;
import automapper.entities.order.OrderService;
import automapper.entities.user.User;
import automapper.entities.user.UserLoginDTO;
import automapper.entities.user.UserRegistrationDTO;
import automapper.entities.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.Validator;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Scanner;

import static automapper.ApplicationStrings.*;

@Component
public class Application implements CommandLineRunner {
    private final GameService gameService;
    private final OrderService orderService;
    private final UserService userService;
    private Validator validator;

    private User currentUser;

    @Autowired
    public Application(GameService gameService, OrderService orderService, UserService userService, Validator validator) {
        this.gameService = gameService;
        this.orderService = orderService;
        this.userService = userService;
        this.validator = validator;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("Exit")) {
            String command = input.split("\\|")[0];

            switch (command) {
                case "RegisterUser":
                    try {
                        this.currentUser = userService.registerUser(new UserRegistrationDTO(input));
                        System.out.printf(REGISTRATION_SUCCESSFUL, currentUser.getEmail());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "LoginUser":
                    try {
                        this.currentUser = userService.logInUser(new UserLoginDTO(input));
                        this.orderService.emptyCart();
                        System.out.printf(LOGIN_SUCCESSFUL, currentUser.getEmail());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Logout":
                    try {
                        checkIfLogged();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.printf(LOGOUT_SUCCESSFUL, this.currentUser.getEmail());
                    this.currentUser = null;
                    break;

                case "AddGame":
                    try {
                        checkCanAdmin();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    try {
                        Game game = gameService.addGame(input);
                        System.out.printf(GAME_ADDED_SUCCESSFULLY, game.getTitle());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "EditGame":
                    try {
                        gameService.editGame(input);
                        System.out.println(GAME_EDITED_SUCCESSFULLY);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "DeleteGame":
                    try {
                        gameService.deleteGame(input);
                        System.out.println("Game deleted");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "AllGames":
                    gameService.getAllGames().forEach(System.out::println);
                    break;
                case "DetailGame":
                    try {
                        System.out.println(gameService.getDetailInfo(input));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "OwnedGames":
                    try {
                        checkIfLogged();
                        List<GameTitleDTO> ownedGames = userService.getOwnedGames(currentUser);

                        if(ownedGames.isEmpty()){
                            System.out.println(USER_DOESNT_OWN_GAMES);
                            break;
                        }

                        ownedGames.forEach(System.out::println);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "AddItem":
                    try {
                        checkIfLogged();
                        System.out.println(orderService.addGameToCart(input, this.currentUser));

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "RemoveItem":
                    try {
                        checkIfLogged();
                        System.out.println(orderService.removeFromCart(input));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "BuyItems":
                    try {
                        checkIfLogged();
                        BigDecimal totalCost = orderService.buyGames(this.currentUser);
                        System.out.printf(BOUGHT_GAMES_FOR, totalCost);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "help":
                    System.out.println(HELP);
                    break;
                default:
                    System.out.println(UNSUPPORTED_COMMAND);
            }

            input = scanner.nextLine();
        }
    }

    private void checkCanAdmin() {
        checkIfLogged();

        if (!this.currentUser.isAdministrator()) {
            throw new IllegalStateException(USER_IS_NOT_ADMIN);
        }
    }

    private void checkIfLogged() {
        if (this.currentUser == null) {
            throw new IllegalStateException(NO_ACTIVE_USER);
        }
    }
}
