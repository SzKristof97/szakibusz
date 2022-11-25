package me.szkristof.szakibuszapi.exceptions.userexceptions;

public class UserAlreadyExsitsException extends RuntimeException {

    public UserAlreadyExsitsException(String message) {
        super(message);
    }
}
