package microservice.topic;

import microservice.topic.domain.models.Status;
import microservice.topic.domain.models.Topic;
import microservice.topic.domain.repositories.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class TopicApp {
    public static void main(String[] args) {
        SpringApplication.run(TopicApp.class, args);
    }


    @Autowired
    private Topics topics;


    @PostConstruct
    public void loadData(){
        topics.save(new Topic("JSF problem", "Just why I use JSF", 1L, 1L, Status.OPEN));
        topics.save(new Topic("Empty State is weird", "I'm confusing when I use empty state design patter", 2L, 2L, Status.CLOSE));
        topics.save(new Topic("Docker ps", "I can't see container when I exec `docker ps`", 3L, 3L, Status.SOLVED));
    }
}
