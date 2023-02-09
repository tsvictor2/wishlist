package ru.raiffeisen.wishlist.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {
    ACQUIRING(7), ACDC(5), DCC(5), CREDIT(5), CURRENCY(5), ACCOUNT(4), ONLINE(7);
    private final int limit;
}
