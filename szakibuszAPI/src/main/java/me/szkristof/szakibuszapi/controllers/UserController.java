package me.szkristof.szakibuszapi.controllers;

import me.szkristof.szakibuszapi.controllers.forms.LoginForm;
import me.szkristof.szakibuszapi.controllers.forms.RegisterForm;
import me.szkristof.szakibuszapi.exceptions.userexceptions.UserAlreadyExsitsException;
import me.szkristof.szakibuszapi.exceptions.userexceptions.UserNotFoundException;
import me.szkristof.szakibuszapi.exceptions.userexceptions.UserPasswordNotMatchException;
import me.szkristof.szakibuszapi.models.UserEntity;
import me.szkristof.szakibuszapi.services.UserService;
import me.szkristof.szakibuszapi.utilities.ErrorResponse;
import me.szkristof.szakibuszapi.utilities.SHA256Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * This class is responsible for handling the user related requests. (login, register, etc.)
 */
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    //<editor-fold default-state="collapsed" desc="Post MAPPING">
    @PostMapping("/user/login")
    public UserEntity login(
            @RequestBody LoginForm loginForm
    ) {
        return userService.loginUser(loginForm.getUsername(), SHA256Converter.convert(loginForm.getPassword()));
    }

    @PostMapping("/user/register")
    public UserEntity register(
            @RequestBody RegisterForm registerForm
    ) {
        return userService.registerUser(registerForm.getUsername(), SHA256Converter.convert(registerForm.getPassword()), registerForm.getEmail());
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Exception Handling">
    @ExceptionHandler(value = UserAlreadyExsitsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleTaskNotFoundException(UserAlreadyExsitsException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleTaskNotFoundException(UserNotFoundException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(value = UserPasswordNotMatchException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleTaskNotFoundException(UserPasswordNotMatchException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
    //</editor-fold>
}
