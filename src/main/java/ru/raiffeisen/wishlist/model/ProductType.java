package ru.raiffeisen.wishlist.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {
    ACQUIRING(700), ADM(500), DCC(500);
    private final int limit;
}
