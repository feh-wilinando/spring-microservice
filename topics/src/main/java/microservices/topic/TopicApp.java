package microservices.topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TopicApp {
    public static void main(String[] args) {
        SpringApplication.run(TopicApp.class, args);
    }
}
