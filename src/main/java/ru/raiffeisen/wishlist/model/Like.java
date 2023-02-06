package ru.raiffeisen.wishlist.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("LIKE_")
public class Like {
    @Id
    private String email;
}
