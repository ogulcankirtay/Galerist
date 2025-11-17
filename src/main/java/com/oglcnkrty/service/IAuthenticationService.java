package com.oglcnkrty.service;


import com.oglcnkrty.dto.AuthResponse;
import com.oglcnkrty.dto.DtoUser;
import com.oglcnkrty.model.AuthRequest;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest authRequest);

    public AuthResponse authenticate(AuthRequest authRequest);
}
