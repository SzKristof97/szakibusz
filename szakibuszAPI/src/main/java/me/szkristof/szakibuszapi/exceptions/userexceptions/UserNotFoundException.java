package me.szkristof.szakibuszapi.exceptions.userexceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
