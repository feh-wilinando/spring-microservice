package microservice.answer.domain.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import microservice.answer.domain.dtos.Topic;
import microservice.answer.domain.dtos.User;
import microservice.answer.domain.models.Answer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TopicService {
    private final RestTemplate restTemplate;

    public TopicService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getByFallback")
    public Topic getBy(Answer answer){
        return restTemplate.getForObject("http://TOPICS/{id}", Topic.class, answer.getTopicId());
    }

    public Topic getByFallback(Answer answer){
        return new Topic(answer.getTopicId(), "Unknown", "Unknown", User.createUnknownUserWith(answer));
    }
}
