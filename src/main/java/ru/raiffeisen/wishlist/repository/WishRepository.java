package ru.raiffeisen.wishlist.repository;

import org.springframework.data.repository.CrudRepository;
import ru.raiffeisen.wishlist.model.Wish;

public interface WishRepository extends CrudRepository<Wish, Long> {}
