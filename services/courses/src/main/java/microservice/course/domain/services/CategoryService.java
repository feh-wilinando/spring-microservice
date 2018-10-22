package microservice.course.domain.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import microservice.course.domain.dtos.Category;
import microservice.course.domain.models.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryService {
    private final RestTemplate restTemplate;

    public static Category unknownCategory = new Category("Unknown");

    public CategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "loadByFallback")
    public Category loadBy(Course course){
        String url = "http://CATEGORY/{id}";

        ResponseEntity<Category> response = restTemplate.getForEntity(url, Category.class, course.getId());

        if (response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }

        String msg = String.format("Response <%s>", response.getStatusCode());

        throw new RestClientException(msg);
    }

    public Category loadByFallback(Course course){
        System.out.println("Using Fallback");
        return unknownCategory;
    }
}
