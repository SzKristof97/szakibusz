package me.szkristof.szakibuszapi.exceptions.userexceptions;

/**
 * This exception is thrown when the user's password is not matching with the one in the database.
 */
public class UserPasswordNotMatchException extends RuntimeException {

    public UserPasswordNotMatchException(String message) {
        super(message);
    }
}
