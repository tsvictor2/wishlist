package ru.raiffeisen.wishlist.model;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
public enum Status {
    MODERATION(10000),
    IN_VOTE(10001),
    BACKLOG(10013),
    START(10014),
    IN_PROGRESS(10012),
    DONE(10002),
    CANCEL(10015);

    private final long jiraId;

    public static Optional<Status> findByJiraId(final long jiraId) {
        return Arrays.stream(values()).filter(value -> value.jiraId == jiraId).findFirst();
    }
}
