package me.szkristof.szakibuszapi.interfaces;

import me.szkristof.szakibuszapi.models.UserEntity;

public interface IUserService {
    UserEntity registerUser(String username, String password, String email);
    UserEntity loginUser(String username, String password);
}
