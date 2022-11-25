package me.szkristof.szakibuszapi.exceptions.userexceptions;

public class UserPasswordNotMatchException extends RuntimeException {

    public UserPasswordNotMatchException(String message) {
        super(message);
    }
}
