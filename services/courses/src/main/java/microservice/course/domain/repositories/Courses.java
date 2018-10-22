package microservice.course.domain.repositories;

import microservice.course.domain.models.Course;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface Courses extends Repository<Course, Long> {

    Optional<Course> findById(Long id);

    List<Course> findAll();

    void save(Course course);
}
