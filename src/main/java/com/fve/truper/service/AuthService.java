package com.fve.truper.service;

import com.fve.truper.auth.LoginRequest;
import com.fve.truper.auth.RegisterRequest;
import com.fve.truper.auth.TokenResponse;
import com.fve.truper.entity.User;

public interface AuthService {
    public TokenResponse register(RegisterRequest request);

    public TokenResponse login(LoginRequest request);

    public void saveUserToken( User user, String jwtToken);

    public void revokeAllUserTokens(User user);

    public TokenResponse refreshToken(String refreshToken);
}
