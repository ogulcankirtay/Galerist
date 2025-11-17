package com.oglcnkrty.service.impl;

import com.oglcnkrty.dto.AuthResponse;
import com.oglcnkrty.dto.DtoUser;
import com.oglcnkrty.enums.ErrorType;
import com.oglcnkrty.exception.BaseException;
import com.oglcnkrty.exception.ErrorMessage;
import com.oglcnkrty.jwt.JWTService;
import com.oglcnkrty.model.AuthRequest;
import com.oglcnkrty.model.RefreshToken;
import com.oglcnkrty.model.User;
import com.oglcnkrty.repository.RefreshTokenRepository;
import com.oglcnkrty.repository.UserRepository;
import com.oglcnkrty.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DaoAuthenticationProvider authenticationProvider;

    @Autowired
    JWTService jwtService;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Override
    public DtoUser register(AuthRequest authRequest) {
        DtoUser dtoUser = new DtoUser();
        User savedUser = userRepository.save(createUser(authRequest));
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            authenticationProvider.authenticate(token);

            Optional<User> optUser = userRepository.findByUsername(authRequest.getUsername());

            String accessToken = jwtService.generateToken(optUser.get());
            RefreshToken refreshToken = refreshTokenRepository.save(createRefreshToken(optUser.get()));

            return new AuthResponse(accessToken, refreshToken.getRefreshToken());

        } catch (AuthenticationException e) {
            throw new BaseException(new ErrorMessage(ErrorType.USERNAME_PASSWORD_INVALID, e.getMessage()));
        }
    }

    private User createUser(AuthRequest input) {
        User user = new User();
        user.setUsername(input.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(input.getPassword()));
        user.setCreationDate(new Date());
        return user;
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setCreationDate(new Date());
        refreshToken.setExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        return refreshToken;
    }
}
