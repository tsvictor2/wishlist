package ru.raiffeisen.wishlist.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.wishlist.controller.model.AuthenticationRequest;
import ru.raiffeisen.wishlist.controller.model.AuthenticationResponse;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
@Validated
public class AuthenticationController {

    @Operation(summary = "Логин")
    @PostMapping("/login")
    public AuthenticationResponse list(@RequestBody AuthenticationRequest request) {
        return new AuthenticationResponse(
                new String(
                        Base64.getEncoder().encode(
                                request.getEmail().getBytes(StandardCharsets.UTF_8))));
    }
}
