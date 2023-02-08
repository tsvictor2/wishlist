package ru.raiffeisen.wishlist.repository;

import org.springframework.data.repository.CrudRepository;
import ru.raiffeisen.wishlist.model.Wish;

import java.util.Optional;

public interface WishRepository extends CrudRepository<Wish, Long> {
    Optional<Wish> findByJiraIssueId(Long jiraIssueId);
}
