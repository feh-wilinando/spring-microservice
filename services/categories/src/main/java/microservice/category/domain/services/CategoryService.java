package microservice.category.domain.services;

import microservice.category.application.forms.CategoryForm;
import microservice.category.domain.models.Category;
import microservice.category.domain.repositories.Categories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final Categories repository;

    public CategoryService(Categories repository) {
        this.repository = repository;
    }


    public List<Category> listAll() {
        return repository.findAll();
    }

    public Optional<Category> loadBy(Long id) {
        return repository.findById(id);
    }

    public Optional<Category> createCategoryBy(CategoryForm form) {
        Optional<Category> aPossibleCategory = Category.newCategoryBy(form);

        aPossibleCategory.ifPresent(repository::save);

        return aPossibleCategory;
    }
}
