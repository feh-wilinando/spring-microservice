package microservice.answer;

import microservice.answer.domain.models.Answer;
import microservice.answer.domain.repositories.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class AnswerApp {
    public static void main(String[] args) {
        SpringApplication.run(AnswerApp.class, args);
    }


    @Autowired
    private Answers answers;

    @PostConstruct
    public void loadData(){
        answers.save(new Answer(1L, 1L, "Bla bla bla 1"));
        answers.save(new Answer(1L, 2L, "Bla bla bla 2"));
        answers.save(new Answer(2L, 3L, "Bla bla bla 3"));
    }
}
