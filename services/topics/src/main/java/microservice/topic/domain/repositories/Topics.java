package microservice.topic.domain.repositories;

import microservice.topic.domain.models.Topic;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface Topics extends Repository<Topic, Long> {

    List<Topic> findAll();
    Optional<Topic> findById(Long id);
    void save(Topic topic);
}
