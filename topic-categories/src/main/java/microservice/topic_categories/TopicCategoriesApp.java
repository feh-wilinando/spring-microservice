package microservice.topic_categories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TopicCategoriesApp {
    public static void main(String[] args) {
        SpringApplication.run(TopicCategoriesApp.class, args);
    }
}
