package microservices.topic.domain.service;

import microservices.topic.domain.model.category.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final RestTemplate client;
    private String categoriesURL = "http://localhost:8090/";

    public CategoryService(RestTemplate client) {
        this.client = client;
    }

    public List<Category> findAll(){
        Category[] result = client.getForObject(categoriesURL, Category[].class);

        return Arrays.asList(result);
    }

    public Optional<Category> loadByName(String name){
        String url = String.format("%s{name}", categoriesURL);

        Category result = client.getForObject(url, Category.class, name);

        return Optional.ofNullable(result);
    }
}
