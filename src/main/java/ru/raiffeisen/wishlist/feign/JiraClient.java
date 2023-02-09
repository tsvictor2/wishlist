package ru.raiffeisen.wishlist.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.raiffeisen.wishlist.config.FeignConfig;
import ru.raiffeisen.wishlist.feign.model.JiraCreateIssueRequest;
import ru.raiffeisen.wishlist.feign.model.JiraCreateIssueResponse;

@FeignClient(
        name = "jiraClient",
        url = "${jira.url}",
        configuration = FeignConfig.class,
        path = "/rest/api/3")

public interface JiraClient {
    @PostMapping(value = "/issue")
    JiraCreateIssueResponse createIssue(@RequestBody JiraCreateIssueRequest request);
}

