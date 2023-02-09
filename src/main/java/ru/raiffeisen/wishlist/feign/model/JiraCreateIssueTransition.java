package ru.raiffeisen.wishlist.feign.model;

import lombok.Builder;
import lombok.Data;

@Data
public class JiraCreateIssueTransition {
    public JiraCreateIssueTransition(int transitionId) {
        this.transition = Transition.builder()
                .id(String.valueOf(transitionId))
                .build();
    }

    private Transition transition;

    @Data
    @Builder
    public static class Transition {
        private String id;
    }
}
