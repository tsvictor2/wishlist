package ru.raiffeisen.wishlist.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {
    ACQUIRING(7, 10020),
    ACDC(5, 10021),
    DCC(5, 10022),
    CREDIT(5, 10023),
    OFFICE(4, 10024),
    CURRENCY(5, 10025),
    ACCOUNT(4, 10026),
    ONLINE(7, 10027);
    private final int limit;
    private final long jiraProjectId;
}
