package ru.raiffeisen.wishlist.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
}
