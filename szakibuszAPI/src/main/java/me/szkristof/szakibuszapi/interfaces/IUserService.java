package me.szkristof.szakibuszapi.interfaces;

import me.szkristof.szakibuszapi.models.UserEntity;

/**
 * This interface is used to define the methods that are used to interact with the database.
 */
public interface IUserService {
    UserEntity registerUser(String username, String password, String email);
    UserEntity loginUser(String username, String password);
}
