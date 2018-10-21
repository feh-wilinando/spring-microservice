package microservices.topic.domain.model.topic;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import microservices.topic.domain.model.category.Category;

import java.time.Instant;

@RequiredArgsConstructor
public class Topic {

    @Getter
    @NonNull
    private Long id;

    @Getter
    private Instant createdAt = Instant.now();

    @Getter
    @NonNull
    private String categoryName;

    @Getter
    private Status status = Status.OPEN;

    @NonNull
    private Content content;

    public String getSubject() {
        return content.getSubject();
    }

    public String getDescription() {
        return content.getDescription();
    }

    public boolean isSolved(){
        return Status.SOLVED.equals(status);
    }
}
