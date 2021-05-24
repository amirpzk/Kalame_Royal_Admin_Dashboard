package com.Prana.KalameRoyal.Authentication;

public interface AuthenticationService {

    String login(String username, String password);

    boolean validateToken(String token);

}
