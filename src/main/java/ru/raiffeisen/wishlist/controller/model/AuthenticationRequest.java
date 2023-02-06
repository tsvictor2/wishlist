package ru.raiffeisen.wishlist.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
public class AuthenticationRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
