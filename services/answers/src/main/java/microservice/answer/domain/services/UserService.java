package microservice.answer.domain.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import microservice.answer.domain.dtos.User;
import microservice.answer.domain.models.Answer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getByFallback")
    public User getBy(Answer answer){
        return restTemplate.getForObject("http://USERS/{id}", User.class, answer.getUserId());
    }

    public User getByFallback(Answer answer){
        return new User(answer.getUserId(), "Unknown");
    }
}
