package com.oglcnkrty.controller;

import com.oglcnkrty.dto.AuthResponse;
import com.oglcnkrty.dto.DtoUser;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.model.AuthRequest;
import com.oglcnkrty.model.RefreshTokenRequest;

public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest request);
    public AuthResponse authenticate(AuthRequest authRequest);
    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
