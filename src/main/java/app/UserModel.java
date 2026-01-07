package app;

import java.util.UUID;

import enums.UserRole;

public class UserModel {
    public String username;
    public String email;
    public UserRole role;
    public UUID id;

    public UserModel(String username, String email, UserRole role, UUID id) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.id = id;
    }
}