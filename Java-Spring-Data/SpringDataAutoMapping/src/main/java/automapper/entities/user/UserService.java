package automapper.entities.user;

import automapper.entities.exceptions.EmailExistException;
import automapper.entities.exceptions.EmailOrPasswordWrong;
import automapper.entities.exceptions.PasswordsNotMatchingException;
import automapper.entities.game.GameTitleDTO;

import javax.validation.ConstraintViolationException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface UserService {
    User registerUser(UserRegistrationDTO user) throws InvalidKeySpecException, EmailExistException, ConstraintViolationException, PasswordsNotMatchingException;

    User getUserByEmail(String email);

    User logInUser(UserLoginDTO dto) throws EmailOrPasswordWrong, InvalidKeySpecException;

    List<GameTitleDTO> getOwnedGames(User user);
}
