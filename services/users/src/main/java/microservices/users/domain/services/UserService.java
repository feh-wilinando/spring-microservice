package microservices.users.domain.services;

import microservices.users.application.forms.UserForm;
import microservices.users.domain.models.User;
import microservices.users.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public List<User> listAll(){
        return repository.findAll();
    }

    public Optional<User> createUserBy(UserForm form){
        Optional<User> aPossibleUser = User.newUserBy(form);

        aPossibleUser.ifPresent(repository::save);

        return aPossibleUser;
    }

    public Optional<User> loadBy(Long id) {
        return repository.findById(id);
    }

}
