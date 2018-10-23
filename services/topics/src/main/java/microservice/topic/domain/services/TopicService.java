package microservice.topic.domain.services;

import microservice.topic.application.dtos.TopicOutput;
import microservice.topic.domain.dtos.Category;
import microservice.topic.domain.dtos.User;
import microservice.topic.domain.models.Topic;
import microservice.topic.domain.repositories.Topics;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {
    private final Topics topics;
    private final CategoryService categoryService;
    private final UserService userService;

    public TopicService(Topics topics, CategoryService categoryService, UserService userService) {
        this.topics = topics;
        this.categoryService = categoryService;
        this.userService = userService;
    }


    public List<TopicOutput> listAll(){
        return topics
                .findAll()
                    .stream()
                        .map(this::toTopicOutput)
                            .collect(Collectors.toList());
    }

    public Optional<TopicOutput> loadBy(Long id){
        return topics.findById(id).map(this::toTopicOutput);
    }


    public TopicOutput toTopicOutput(Topic topic){
        Category category = categoryService.loadBy(topic);
        User user = userService.loadBy(topic);

        return new TopicOutput(topic, category, user);
    }
}
