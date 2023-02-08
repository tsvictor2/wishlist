package ru.raiffeisen.wishlist.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.raiffeisen.wishlist.exception.StatusNotFoundException;
import ru.raiffeisen.wishlist.model.Status;

@Getter
@Builder
@AllArgsConstructor
public class JiraIssueStatusChangedRequest {
    private Long id;
    private String name;

    public Status toStatus() {
        return Status.findByJiraId(id).orElseThrow(StatusNotFoundException::new);
    }
}
