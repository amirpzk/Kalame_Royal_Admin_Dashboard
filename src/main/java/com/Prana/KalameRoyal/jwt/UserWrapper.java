package com.Prana.KalameRoyal.jwt;

import com.Prana.KalameRoyal.Authentication.Role;

import java.util.ArrayList;
import java.util.List;

public class UserWrapper {

    private static String USERNAME = "username";
    private String username;
    private static String PASSWORD = "password";
    private String password;
    private static String ROLES = "roles";
    private List<RoleWrapper> roles;


    public UserWrapper(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;

        List<RoleWrapper> roleWrappers = new ArrayList<>();
        for (Role role : roles) {
            RoleWrapper roleWrapper = new RoleWrapper(role.getRole());
            roleWrappers.add(roleWrapper);
        }
        this.roles = roleWrappers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static void setUSERNAME(String USERNAME) {
        UserWrapper.USERNAME = USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        UserWrapper.PASSWORD = PASSWORD;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getROLES() {
        return ROLES;
    }

    public static void setROLES(String ROLES) {
        UserWrapper.ROLES = ROLES;
    }

    public List<RoleWrapper> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleWrapper> roles) {
        this.roles = roles;
    }
}
