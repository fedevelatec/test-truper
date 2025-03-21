package com.fve.truper.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponse(
        @JsonProperty("access_token")
        String accessToken,
        @JsonProperty("access_token")
        String refreshToken
) {
}
