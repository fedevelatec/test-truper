package com.fve.truper.service;

import com.fve.truper.auth.LoginRequest;
import com.fve.truper.auth.RegisterRequest;
import com.fve.truper.auth.TokenResponse;
import com.fve.truper.entity.User;
import com.fve.truper.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TokenResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();
        var saveduser = userRepository.save(user);
        var jwtToken =
        return null;
    }

    @Override
    public TokenResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public void saveUserToken(User user, String jwtToken) {

    }

    @Override
    public void removeAllUserTokens(User user) {

    }

    @Override
    public TokenResponse refreshToken(String refreshToken) {
        return null;
    }
}
