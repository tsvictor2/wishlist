package ru.raiffeisen.wishlist.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.raiffeisen.wishlist.model.ProductType;
import ru.raiffeisen.wishlist.model.Status;
import ru.raiffeisen.wishlist.model.Subscription;
import ru.raiffeisen.wishlist.model.Wish;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Set;


@Getter
@Builder
@AllArgsConstructor
public class AddWishRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private ProductType product;
    private Boolean internal;

    public Wish toWish(String email, String jiraIssuId) {
        return Wish.builder()
                .title(title)
                .description(description)
                .product(product)
                .subscription(Set.of(Subscription.builder().email(email).build()))
                .created(OffsetDateTime.now())
                .status(Status.MODERATION)
                .isInternal(internal)
                .jiraIssueId(Long.valueOf(jiraIssuId))
                .build();
    }
}
