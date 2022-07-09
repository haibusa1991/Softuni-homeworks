package automapper;

public class ApplicationStrings {
    public static final String PASSWORDS_MISMATCH = "Password and confirmed password do not match";
    public static final String EMAIL_ALREADY_REGISTERED = "User with this email is already registered";
    public static final String UNSUPPORTED_COMMAND = "Unsupported command. Type \"help\" for list of commands";
    public static final String REGISTRATION_SUCCESSFUL = "Successfully registered logged in user with email %s%n";
    public static final String EMAIL_OR_PASSWORD_WRONG = "Email or password is invalid.";
    public static final String LOGIN_SUCCESSFUL = "User %s logged in successfully%n";
    public static final String LOGOUT_SUCCESSFUL = "User %s logged out successfully%n";
    public static final String NO_ACTIVE_USER = "No user is currently logged in";
    public static final String USER_IS_NOT_ADMIN = "Currently logged user does not have administrator privileges";
    public static final String INCORRECT_NUMBER_OF_ARGUMENTS = "Number of arguments is incorrect. Expected %d, got %d%n";
    public static final String GAME_MALFORMED_DATA = "Data is malformed";
    public static final String GAME_ADDED_SUCCESSFULLY = "Game \"%s\" added successfully%n";
    public static final String GAME_NO_SUCH_ID = "Game with id %d cannot be found%n";
    public static final String GAME_NO_SUCH_TITLE = "Game with name \"%s\" cannot be found%n";
    public static final String GAME_EDITED_SUCCESSFULLY = "Game parameters updated successfully";
    public static final String GAME_ALREADY_IN_CART = "Game already has been added to cart";
    public static final String GAME_ALREADY_OWNED = "User with email %s already owns \"%s\"%n";
    public static final String CART_IS_EMPTY = "Cart is empty. Add same games first";
    public static final String GAME_NOT_IN_CART = "Game with name \"%s\" is not in the cart%n";
    public static final String GAME_REMOVED_FROM_CART = "Game \"%s\" removed from cart%n";
    public static final String BOUGHT_GAMES_FOR = "Bought games for %.2f euro successfully";
    public static final String USER_DOESNT_OWN_GAMES = "Current user doesn't own any games";

    public static final String HELP = """
            RegisterUser|<email>|<password>|<confirmPassword>|<fullName> - Adds new user to the database.
            The requirements for valid parameters are:
                *Email – user email address.
                *Password – length must be at least 6 symbols and must contain at least 1 uppercase, 1 lowercase letter and 1 digit.
                *Confirm Password – must match the provided password.
                *Full name - name of the user.
                       
            LoginUser|<email>|<password> - Logs in an user if it exists.
                *Logged in user can logout.
                       
            Logout – This command logs out the user from the system.
                                                                   
            AddGame|<title>|<price>|<size>|<trailer>|<thumbnailURL>|<description>|<releaseDate> - adds new game to the database.
                A game will be added/edited only to the catalog, if it matches the following criteria:
                *Title – has to begin with an uppercase letter and must have length between 3 and 100 symbols (inclusively).
                *Price – must be a positive number.
                *Size – must be a positive number.
                *Trailer – only videos from YouTube are allowed. Enter video id or full link.
                *Thumbnail URL – it should be a link starting with http:// or https://
                *Description – must be at least 20 symbols
                        
            EditGame|<id>|<values> - A game should be edited in case of valid id.
                        
            DeleteGame|<id> - A game should be deleted in case of valid id.
                        
            AllGames - prints titles and price of all games.
                        
            DetailsGame|<gameTitle> - print details about а single game.
                        
            OwnedGames – prints the games owned by the currently logged in user.

            AddItem|<gameTitle> - adds a game to shopping cart.
            
            RemoveItem|<gameTitle> - removes a game from the shopping cart.
            
            BuyItems – buys all games in the shopping cart.""";


}
