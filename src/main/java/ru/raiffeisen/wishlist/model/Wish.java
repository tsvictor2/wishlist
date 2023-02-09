package ru.raiffeisen.wishlist.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@Table("wish")
public class Wish {
    @Id
    private Long id;
    private String title;
    private String description;
    private ProductType product;
    @MappedCollection(idColumn = "wish_id")
    @Builder.Default
    private Set<Like> likes = new HashSet<>();
    @MappedCollection(idColumn = "wish_id")
    @Builder.Default
    private Set<Subscription> subscription = new HashSet<>();
    private OffsetDateTime created;
    private Status status;
    private Boolean isInternal;
    private Long jiraIssueId;
}
