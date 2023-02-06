package ru.raiffeisen.wishlist.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("PRODUCT")
public class Product implements Persistable<String> {
    @Id
    private String name;
    private int limit;

    @Override
    public String getId() {
        return name;
    }

    @Override
    @Transient
    public boolean isNew() {
        return true;
    }
}
