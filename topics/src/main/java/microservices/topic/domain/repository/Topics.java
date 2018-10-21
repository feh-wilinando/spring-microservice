package microservices.topic.domain.repository;

import microservices.topic.domain.model.topic.Content;
import microservices.topic.domain.model.topic.Topic;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public interface Topics {
    default List<Topic> findAll() {
        Content content = new Content("Probleam with spring cloud", "I can't connect to service discovery");

        Topic topic = new Topic(1L, "Java", content);

        return Arrays.asList(topic);
    }

    ;

    default Optional<Topic> findById(Long id) {
        Content content = new Content("Probleam with spring cloud", "I can't connect to service discovery");

        Topic topic = new Topic(1L, "Java", content);

        return Optional.of(topic);
    }
}

