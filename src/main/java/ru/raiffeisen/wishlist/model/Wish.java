package ru.raiffeisen.wishlist.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
@Table("WISH")
public class Wish {
    @Id
    private Long id;
    private String title;
    private String description;
    private ProductType product;
    @MappedCollection(idColumn = "WISH_ID")
    private Set<Like> likes;
    @MappedCollection(idColumn = "WISH_ID")
    private Set<Subscription> subscription;
    private OffsetDateTime created;
    private Status status;
}
