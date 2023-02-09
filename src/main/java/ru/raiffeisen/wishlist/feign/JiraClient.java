package ru.raiffeisen.wishlist.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import ru.raiffeisen.wishlist.config.FeignConfig;
import ru.raiffeisen.wishlist.feign.model.JiraCreateIssueResponse;

@FeignClient(
        value = "jiraClient",
        url = "${jira.url}",
        configuration = FeignConfig.class,
        path = "/rest/api/3")
public interface JiraClient {
    @PostMapping(value = "/issue")
    JiraCreateIssueResponse createIssue(@PathVariable String accountNumber);
}


