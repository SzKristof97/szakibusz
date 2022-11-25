package me.szkristof.szakibuszapi.exceptions.userexceptions;

/**
 * This exception is thrown when a user is not found in the database
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
