package microservice.category.application.controllers;

import microservice.category.application.forms.CategoryForm;
import microservice.category.domain.models.Category;
import microservice.category.domain.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Category> list(){
        return service.listAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Category> getBy(@PathVariable Long id){

        return service.loadBy(id)
                .map(ResponseEntity::ok)
                    .orElseGet(ResponseEntity.noContent()::build);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Category> save(@RequestBody CategoryForm form){
        return service.createCategoryBy(form)
                .map(this::toCreatedResponse)
                    .orElseGet(ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)::build);
    }

    private ResponseEntity<Category>  toCreatedResponse(Category category) {
        URI uri = URI.create("/" + category.getId());

        return ResponseEntity.created(uri).body(category);
    }
}
