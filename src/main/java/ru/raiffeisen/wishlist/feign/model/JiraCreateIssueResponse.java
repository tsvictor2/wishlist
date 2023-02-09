package ru.raiffeisen.wishlist.feign.model;

import lombok.Data;

@Data
public class JiraCreateIssueResponse {
    private String id;
    private String key;
}
