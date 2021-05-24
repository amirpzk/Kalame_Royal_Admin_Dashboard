package com.Prana.KalameRoyal.Authentication;

import com.Prana.KalameRoyal.jwt.JwtFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtFactory jwtFactory;

    @Override
    public String login(String username, String password) {
        if ( !username.equals("admin") ){
            throw new RuntimeException();
        }
        String generatedAdminPassword = encoder.encode("admin");
        if ( !encoder.matches(password, generatedAdminPassword)){
            throw new RuntimeException();
        }

        String token = jwtFactory.generateToken(username);
        return token;
    }


    @Override
    public boolean validateToken(String token) {
        String role = jwtFactory.parseToken(token);
        if (role.equalsIgnoreCase("admin")){
            return true;
        }
        return false;
    }
}
