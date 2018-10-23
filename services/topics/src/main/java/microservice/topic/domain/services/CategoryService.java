package microservice.topic.domain.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import microservice.topic.domain.dtos.Category;
import microservice.topic.domain.models.Topic;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryService {
    private final RestTemplate restTemplate;

    public CategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @HystrixCommand(fallbackMethod = "loadByFallback")
    public Category loadBy(Topic topic){
        return restTemplate.getForObject("http://CATEGORIES/{id}", Category.class, topic.getCategoryId());
    }


    public Category loadByFallback(Topic topic){
        return new Category("Unknown");
    }
}
