package com.fve.truper.auth;

public record LoginRequest(
        String email,
        String password
) {
}
