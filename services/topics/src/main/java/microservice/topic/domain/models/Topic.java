package microservice.topic.domain.models;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String shortDescription;

    @NonNull
    private String content;

    @NonNull
    private Long userId;

    @NonNull
    private Long categoryId;


    @NonNull
    @Enumerated
    private Status status;

    @NonNull
    private Instant createdAt = Instant.now();


    public boolean isSolved(){
        return Status.SOLVED.equals(status);
    }
}
