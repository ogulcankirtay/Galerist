package com.oglcnkrty.controller;

import com.oglcnkrty.dto.AuthResponse;
import com.oglcnkrty.dto.DtoUser;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.model.AuthRequest;

public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest request);
    public AuthResponse authenticate(AuthRequest authRequest);
}
