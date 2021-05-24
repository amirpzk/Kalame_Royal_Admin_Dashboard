package com.Prana.KalameRoyal.jwt;

public class RoleWrapper {

    private static String ROLE = "role";
    private String role;

    public RoleWrapper(String role) {
        this.role = role;
    }

    public static String getROLE() {
        return ROLE;
    }

    public static void setROLE(String ROLE) {
        RoleWrapper.ROLE = ROLE;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
