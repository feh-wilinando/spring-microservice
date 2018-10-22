package microservice.category.domain.repositories;

import microservice.category.domain.models.Category;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface Categories extends Repository<Category, Long> {

    void save(Category category);

    Optional<Category> findById(Long id);

    List<Category> findAll();
}
