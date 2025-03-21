package com.fve.truper.auth;

public record RegisterRequest(
        String name,
        String email,
        String password
) {
}
