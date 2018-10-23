package microservice.answer.domain.repositories;

import microservice.answer.domain.models.Answer;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface Answers extends Repository<Answer, Long> {
    List<Answer> findAll();
    Optional<Answer> findById(Long id);
    void save(Answer answer);
}
