package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestAuthenticationController;
import com.oglcnkrty.controller.RestBaseController;
import com.oglcnkrty.dto.AuthResponse;
import com.oglcnkrty.dto.DtoUser;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.model.AuthRequest;
import com.oglcnkrty.model.RefreshTokenRequest;
import com.oglcnkrty.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    IAuthenticationService authenticationService;

    @PostMapping("/register")
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest request) {
        return ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    @Override
    public AuthResponse authenticate(@Valid @RequestBody AuthRequest authRequest) {
        return authenticationService.authenticate(authRequest);
    }

    @PostMapping("/refresh_token")
    @Override
    public AuthResponse refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authenticationService.refreshToken(refreshTokenRequest);
    }
}
