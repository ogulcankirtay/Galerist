package com.oglcnkrty.jwt;

import com.oglcnkrty.enums.ErrorType;
import com.oglcnkrty.exception.BaseException;
import com.oglcnkrty.exception.ErrorMessage;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    JWTService jwtService;
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorizationHeader.substring(7);
        try {
            String usernameFromToken = jwtService.getUsernameFromToken(token);
            if (usernameFromToken != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(usernameFromToken);
                if (userDetails != null && jwtService.isTokenExpired(token)) {
                    UsernamePasswordAuthenticationToken authentication = new
                            UsernamePasswordAuthenticationToken(userDetails, null,
                            userDetails.getAuthorities());

                    SecurityContext securityContext = SecurityContextHolder.getContext();
                    securityContext.setAuthentication(authentication);
                }
            }
        } catch (ExpiredJwtException e) {
            throw new BaseException(new ErrorMessage(ErrorType.TOKEN_IS_EXPIRED, token));
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(ErrorType.GENERAL_EXCEPTION, e.getMessage()));
        }


    }
}
