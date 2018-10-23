package microservice.answer.application.controllers;

import microservice.answer.application.dtos.AnswerOutput;
import microservice.answer.domain.services.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {
    private final AnswerService service;

    public AnswerController(AnswerService service) {
        this.service = service;
    }


    @GetMapping
    public List<AnswerOutput> list(){
        return service.listAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<AnswerOutput> getBy(@PathVariable Long id){
        return service.loadBy(id).map(ResponseEntity::ok).orElseGet(ResponseEntity.noContent()::build);
    }
}
