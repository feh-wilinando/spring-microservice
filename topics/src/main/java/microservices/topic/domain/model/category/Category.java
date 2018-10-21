package microservices.topic.domain.model.category;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Category {

    private String name;
    private Optional<Category> subcategory;

    public Category(String name){
        this.name = name;
        subcategory = Optional.empty();
    }

    public Category(String name, Category subdcategory){
        this.name = name;
        this.subcategory = Optional.of(subdcategory);
    }

}
