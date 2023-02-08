package ru.raiffeisen.wishlist.controller;

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

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/issues")
public class JiraIssueController {

    @Operation(summary = "Оповещение о смене статуса задачи в Jira")
    @PostMapping("/{id}/status-changed")
    public void statusChanged(@PathVariable Long id, @RequestBody Object request) {
        log.info("Received /issues/{}/status-changed with body {}", id, request);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    void onDbActionExecutionException(RuntimeException e) {
        log.warn("Something went wrong.", e);
    }
}
