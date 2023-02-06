package ru.raiffeisen.wishlist.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("SUBSCRIPTION")
public class Subscription {
    @Id
    private String email;
}
