package microservice.topic.domain.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import microservice.topic.domain.dtos.User;
import microservice.topic.domain.models.Topic;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "loadByFallback")
    public User loadBy(Topic topic){
        return restTemplate.getForObject("http://USERS/{id}", User.class, topic.getUserId());
    }

    public User loadByFallback(Topic topic){
        return new User("Unknown", "Unknown");
    }
}
