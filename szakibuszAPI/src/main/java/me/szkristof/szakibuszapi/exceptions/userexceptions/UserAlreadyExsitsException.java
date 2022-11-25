package me.szkristof.szakibuszapi.exceptions.userexceptions;

/**
 * This exception is thrown when a user already exists in the database.
 */
public class UserAlreadyExsitsException extends RuntimeException {

    public UserAlreadyExsitsException(String message) {
        super(message);
    }
}
