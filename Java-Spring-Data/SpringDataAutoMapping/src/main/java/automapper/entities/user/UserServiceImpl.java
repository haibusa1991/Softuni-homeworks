package automapper.entities.user;

import automapper.entities.Mapper;
import automapper.entities.exceptions.EmailExistException;
import automapper.entities.exceptions.EmailOrPasswordWrong;
import automapper.entities.exceptions.PasswordsNotMatchingException;
import automapper.entities.game.GameTitleDTO;
import automapper.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static automapper.ApplicationStrings.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Validator validator;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public User registerUser(UserRegistrationDTO dto) throws InvalidKeySpecException,
            EmailExistException,
            ConstraintViolationException,
            PasswordsNotMatchingException {

        Set<ConstraintViolation<UserRegistrationDTO>> dtoConstraintsViolations = validator.validate(dto);

        if (!dtoConstraintsViolations.isEmpty()) {
            throw new ConstraintViolationException(dtoConstraintsViolations);
        }

        if (!dto.areMatchingPasswords()) {
            throw new PasswordsNotMatchingException(PASSWORDS_MISMATCH);
        }

        User user = new User();
        Mapper.getInstance().getMapper().map(dto, user);

        if (getUserByEmail(user.getEmail()) != null) {
            throw new EmailExistException(EMAIL_ALREADY_REGISTERED);
        }

        boolean shouldBeAdmin = !(this.userRepository.countUserByIdGreaterThan(0) > 0);

        if (shouldBeAdmin) {
            user.setAdministrator(true);
        }

        user.setPassword(PasswordHandler.encodePassword(user.getPassword()));

        return this.userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public User logInUser(UserLoginDTO dto) throws EmailOrPasswordWrong, InvalidKeySpecException {
        User user = this.userRepository.findUserByEmail(dto.getEmail());

        if (user == null) {
            throw new EmailOrPasswordWrong(EMAIL_OR_PASSWORD_WRONG);
        }

        boolean isPasswordCorrect = PasswordHandler.doPasswordsMatch(dto.getPassword(), user.getPassword());

        if (!isPasswordCorrect) {
            throw new EmailOrPasswordWrong(EMAIL_OR_PASSWORD_WRONG);
        }

        return user;
    }

    @Override
    public List<GameTitleDTO> getOwnedGames(User user) {
        List<String> gamesByEmail = userRepository.getGamesByEmail(user.getEmail());

        List<GameTitleDTO> dtos = new ArrayList<>();
        for (String game : gamesByEmail) {
            dtos.add(new GameTitleDTO(game));
        }

        return dtos;
    }

}
