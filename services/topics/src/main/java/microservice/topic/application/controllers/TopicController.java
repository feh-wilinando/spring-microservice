package microservice.topic.application.controllers;

import microservice.topic.application.dtos.TopicOutput;
import microservice.topic.domain.services.TopicService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {
    private final TopicService service;

    public TopicController(TopicService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TopicOutput> list(){
        return service.listAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TopicOutput> getBy(@PathVariable Long id){
        return service
                .loadBy(id)
                    .map(ResponseEntity::ok)
                        .orElseGet(ResponseEntity.noContent()::build);
    }
}
