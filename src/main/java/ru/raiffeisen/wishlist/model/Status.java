package ru.raiffeisen.wishlist.model;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
public enum Status {
    MODERATION(10000, 0),
    IN_VOTE(10001, 5),
    BACKLOG(10013, 4),
    START(10014, 7),
    IN_PROGRESS(10012,8),
    DONE(10002, 9),
    CANCEL(10015, 2);

    private final long jiraId;
    private final int transictionId;

    public static Optional<Status> findByJiraId(final long jiraId) {
        return Arrays.stream(values()).filter(value -> value.jiraId == jiraId).findFirst();
    }

    public static Optional<Status> findByTransactionId(final long transictionId){
        return Arrays.stream(values()).filter(value -> value.transictionId ==  transictionId).findFirst();
    }
}
