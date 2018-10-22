package microservice.category;

import microservice.category.domain.models.Category;
import microservice.category.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@EnableEurekaClient
@SpringBootApplication
public class CategoryApp {
    public static void main(String[] args) {
        SpringApplication.run(CategoryApp.class, args);
    }


    @Autowired
    private CategoryRepository repository;

    @PostConstruct
    public void loadData(){
        repository.save(new Category("Programming"));
        repository.save(new Category("UI/UX"));
        repository.save(new Category("Infrastructure"));
    }
}
