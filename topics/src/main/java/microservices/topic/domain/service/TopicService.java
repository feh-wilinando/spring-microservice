package microservices.topic.domain.service;

import microservices.topic.application.dto.TopicOutput;
import microservices.topic.domain.model.category.Category;
import microservices.topic.domain.model.topic.Topic;
import microservices.topic.domain.repository.Topics;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final Topics topics;
    private final CategoryService categoryService;

    public TopicService(Topics topics, CategoryService categoryService) {
        this.topics = topics;
        this.categoryService = categoryService;
    }

    public Optional<TopicOutput> loadById(Long id) {
        return topics.findById(id).map(this::toOutput);
    }

    public List<TopicOutput> listAll() {
        return topics.findAll().stream().map(this::toOutput).collect(Collectors.toList());
    }


    private TopicOutput toOutput(Topic topic) {
        String categoryName = topic.getCategoryName();
        Category category = categoryService.loadByName(categoryName).orElseThrow(RuntimeException::new);

        return new TopicOutput(topic, category);
    }
}
