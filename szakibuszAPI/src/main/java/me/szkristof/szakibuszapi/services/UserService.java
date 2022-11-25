package me.szkristof.szakibuszapi.services;

import io.swagger.v3.oas.annotations.Parameter;
import me.szkristof.szakibuszapi.exceptions.userexceptions.UserAlreadyExsitsException;
import me.szkristof.szakibuszapi.exceptions.userexceptions.UserNotFoundException;
import me.szkristof.szakibuszapi.exceptions.userexceptions.UserPasswordNotMatchException;
import me.szkristof.szakibuszapi.interfaces.IUserService;
import me.szkristof.szakibuszapi.models.UserEntity;
import me.szkristof.szakibuszapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * This class is responsible for the user related operations.
 */
@Service
public class UserService implements IUserService {

    //<editor-fold default-state="collapsed" desc="Autowired field">
    @Autowired
    private UserRepository userRepository;
    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Methods">
    @Override
    @Parameter(name = "username", description = "The username of the user to register", required = true)
    @Parameter(name = "password", description = "The password of the user to register", required = true)
    @Parameter(name = "email", description = "The email of the user to register", required = true)
    @Description("Registers a new user")
    public UserEntity registerUser(String username, String password, String email) throws UserAlreadyExsitsException {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(username.toLowerCase());
        newUser.setPassword(password);
        newUser.setEmail(email);

        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if (userEntity.isPresent()) {
            throw new UserAlreadyExsitsException("User already exists");
        }

        return userRepository.save(newUser);
    }

    @Override
    @Parameter(name = "username", description = "The username of the user to login", required = true)
    @Parameter(name = "password", description = "The password of the user to login", required = true)
    @Description("Logs in a user")
    public UserEntity loginUser(String username, String password) throws UserNotFoundException, UserPasswordNotMatchException {

        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if (!userEntity.isPresent()) {
            throw new UserNotFoundException("User not found");
        }

        if (!userEntity.get().getPassword().equals(password)) {
            throw new UserPasswordNotMatchException("Password does not match");
        }

        return userEntity.get();
    }

    //</editor-fold>
}
