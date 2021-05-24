package com.Prana.KalameRoyal.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping(value = "/login")
    public ResponseEntity<TokenResponseModel> login(@RequestBody AuthenticationRequestModel model){
        String token = service.login(model.getUsername(), model.getPassword());
        TokenResponseModel response = new TokenResponseModel();
        response.setMessage(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
