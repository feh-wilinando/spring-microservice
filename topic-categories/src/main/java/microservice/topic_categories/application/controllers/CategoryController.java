package microservice.topic_categories.application.controllers;

import microservice.topic_categories.domain.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    static Category java = new Category("Java", new Category("Programming"));

    @GetMapping("{name}")
    public Optional<Category> categoryByName(@PathVariable String name){
        return Optional.of(java);
    }


    @GetMapping
    public List<Category> listAll(){
        return Arrays.asList(java, java, java);
    }
}
