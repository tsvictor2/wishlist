package ru.raiffeisen.wishlist.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.wishlist.controller.handler.AuthorizationHeader;
import ru.raiffeisen.wishlist.controller.model.AddWishRequest;
import ru.raiffeisen.wishlist.controller.model.WishResponse;
import ru.raiffeisen.wishlist.exception.WishNotFoundException;
import ru.raiffeisen.wishlist.model.Like;
import ru.raiffeisen.wishlist.model.Subscription;
import ru.raiffeisen.wishlist.repository.WishRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.StreamSupport;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/wishes")
public class WishController {

    private final WishRepository wishRepository;

    @Operation(summary = "Список заявок")
    @GetMapping
    public List<WishResponse> list(@AuthorizationHeader String email) {
        return StreamSupport.stream(wishRepository.findAll().spliterator(), false)
                .map(wish -> new WishResponse(wish, email)).toList();
    }

    @Operation(summary = "Создание заявки")
    @PostMapping
    public WishResponse add(@AuthorizationHeader String email,
                            @RequestBody @Valid AddWishRequest request) {
        return new WishResponse(wishRepository.save(request.toWish(email)), email);
    }

    @Operation(summary = "Лайк/дизлайк")
    @PostMapping("/{id}/likes")
    public WishResponse like(@AuthorizationHeader String Authorization, @PathVariable Long id) {
        var wish = wishRepository.findById(id).orElseThrow(WishNotFoundException::new);
        if (wish.getLikes().stream().anyMatch(like -> like.getEmail().equals(Authorization))) {
            wish.getLikes().removeIf(like -> like.getEmail().equals(Authorization));
        } else {
            wish.getLikes().add(Like.builder().email(Authorization).build());
        }
        return new WishResponse(wishRepository.save(wish), Authorization);
    }

    @Operation(summary = "Подписка/отписка")
    @PostMapping("/{id}/subscriptions")
    public WishResponse subscribe(@AuthorizationHeader String email, @PathVariable Long id) {
        var wish = wishRepository.findById(id).orElseThrow(WishNotFoundException::new);
        if (wish.getSubscription().stream().anyMatch(like -> like.getEmail().equals(email))) {
            wish.getSubscription().removeIf(like -> like.getEmail().equals(email));
        } else {
            wish.getSubscription().add(Subscription.builder().email(email).build());
        }
        return new WishResponse(wishRepository.save(wish), email);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(WishNotFoundException.class)
    void onDbActionExecutionException() {
        log.warn("Заявка не найдена");
    }
}
