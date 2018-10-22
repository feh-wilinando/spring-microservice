package microservice.course;

import microservice.course.domain.models.Course;
import microservice.course.domain.repositories.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class CourseApp {
    public static void main(String[] args) {
        SpringApplication.run(CourseApp.class, args);
    }

    @Autowired
    private Courses courses;

    @PostConstruct
    public void loadData(){
        courses.save(new Course("Java", 1L));
        courses.save(new Course("IxD", 2L));
        courses.save(new Course("Docker", 3L));
    }
}
