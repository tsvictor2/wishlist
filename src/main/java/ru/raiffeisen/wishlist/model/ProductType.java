package ru.raiffeisen.wishlist.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {
    ACQUIRING(7), ADM(5), DCC(5);
    private final int limit;
}
