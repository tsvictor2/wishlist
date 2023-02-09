package ru.raiffeisen.wishlist.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.raiffeisen.wishlist.model.Wish;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishResponse {

    public WishResponse(Wish wish, String email) {
        this.id = wish.getId();
        this.title = wish.getTitle();
        this.description = wish.getDescription();
        this.product = wish.getProduct().name();
        this.created = wish.getCreated();
        this.status = wish.getStatus().name();
        this.likes = wish.getLikes() == null ? 0 : wish.getLikes().size();
        this.limit = wish.getProduct().getLimit();
        this.liked = wish.getLikes().stream().anyMatch(l -> l.getEmail().equals(email));
        this.subscribed = wish.getSubscription().stream().anyMatch(l -> l.getEmail().equals(email));
        this.internal = Boolean.TRUE.equals(wish.getIsInternal());
        this.jiraIssueId = wish.getJiraIssueId().intValue();
    }

    private Long id;
    private String title;
    private String description;
    private String product;
    private OffsetDateTime created;
    private String status;
    private int likes;
    private int limit;
    private boolean liked;
    private boolean subscribed;
    private boolean internal;
    private int jiraIssueId;
}
