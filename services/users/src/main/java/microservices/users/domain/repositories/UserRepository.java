package microservices.users.domain.repositories;

import microservices.users.domain.models.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
    List<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
}
