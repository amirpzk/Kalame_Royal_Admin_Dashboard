package com.Prana.KalameRoyal.Authentication;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String password;
    private List<Role> roles;

    public User() {
        this.roles = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
