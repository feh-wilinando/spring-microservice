package microservice.topic_categories.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class Category {
    @NonNull
    @Getter
    private String name;

    @Getter
    private Optional<Category> subcategory;

    public Category(String name, Category subcategory) {
        this(name);
        this.subcategory = Optional.of(subcategory);
    }
}
