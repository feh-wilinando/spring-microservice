package microservices.users;

import microservices.users.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import microservices.users.domain.repositories.Users;

import javax.annotation.PostConstruct;

@EnableEurekaClient
@SpringBootApplication
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }


    @Autowired
    private Users repository;

    @PostConstruct
    public void loadData(){
        repository.save(new User("Fernando", "fernando@email.com"));
        repository.save(new User("Willian", "wilian@email.com"));
        repository.save(new User("Furtado", "furtado@email.com"));
    }
}
