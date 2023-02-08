package ru.raiffeisen.wishlist.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("subscription")
public class Subscription {
    @Id
    private Long id;
    private String email;
}
