package microservice.course.application.controllers;

import microservice.course.application.dtos.CourseOutput;
import microservice.course.domain.services.CourseService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CourseOutput> list(){
        return service.listAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CourseOutput> getById(@PathVariable Long id){
        return service.loadBy(id)
                    .map(ResponseEntity::ok)
                        .orElseGet(ResponseEntity.noContent()::build);
    }
}
