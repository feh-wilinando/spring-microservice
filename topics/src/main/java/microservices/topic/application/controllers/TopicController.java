package microservices.topic.application.controllers;

import microservices.topic.application.dto.TopicOutput;
import microservices.topic.domain.service.TopicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    private final TopicService service;

    public TopicController(TopicService service) {
        this.service = service;
    }

    @GetMapping
    public List<TopicOutput> allOpen(){
        return service.listAll();
    }

}
