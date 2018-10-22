package microservice.category.domain.models;

import lombok.*;
import microservice.category.application.forms.CategoryForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    public static Optional<Category> newCategoryBy(CategoryForm form) {
        Category category = new Category(form.getName());
        return Optional.of(category);
    }
}
