package microservices.users.domain.models;

import lombok.*;
import microservices.users.application.forms.UserForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @NonNull
    private String name;

    @Getter
    @NonNull
    private String email;

    public static Optional<User> newUserBy(UserForm form) {

        User user = new User(form.getName(), form.getEmail());

        return Optional.of(user);
    }
}
