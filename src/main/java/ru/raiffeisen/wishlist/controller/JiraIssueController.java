package ru.raiffeisen.wishlist.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.wishlist.controller.model.JiraIssueStatusChangedRequest;
import ru.raiffeisen.wishlist.exception.StatusNotFoundException;
import ru.raiffeisen.wishlist.exception.WishNotFoundException;
import ru.raiffeisen.wishlist.repository.WishRepository;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/issues")
public class JiraIssueController {

    private final WishRepository wishRepository;

    @Operation(summary = "Оповещение о смене статуса задачи в Jira")
    @PostMapping("/{id}/status-changed")
    public void statusChanged(@PathVariable Long id,
                              @RequestBody JiraIssueStatusChangedRequest request) throws JsonProcessingException {
        log.info("POST /issues/{}/status-changed with body={}",
                id, new ObjectMapper().writeValueAsString(request));
        wishRepository.findByJiraIssueId(id)
                .ifPresentOrElse(
                        wish -> {
                            wishRepository.save(wish.toBuilder().status(request.toStatus()).build());
                            //todo: send emails to subscribers
                        },
                        () -> {throw new WishNotFoundException();});
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    void onWishNotFoundException(WishNotFoundException e) {
        log.warn("Заявка не найдена", e);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    void onStatusNotFoundException(StatusNotFoundException e) {
        log.warn("Неизвестный статус", e);
    }
}
