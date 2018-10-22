package microservices.users.application.controllers;

import microservices.users.application.forms.UserForm;
import microservices.users.domain.models.User;
import microservices.users.domain.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> list(){
        return service.listAll();
    }

    @GetMapping(value = "{id:\\d+}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return service.loadBy(id)
                .map(ResponseEntity::ok)
                    .orElseGet(ResponseEntity.noContent()::build);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> newUser(@RequestBody  UserForm form){
        return service.createUserBy(form)
                    .map(this::toCreatedResponse)
                        .orElseGet(ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)::build);
    }

    private ResponseEntity<User> toCreatedResponse(User user) {
        URI uri = URI.create("/" + user.getId());

        return ResponseEntity
                    .created(uri)
                        .body(user);
    }

}
