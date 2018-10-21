package microservices.topic.application.dto;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import microservices.topic.domain.model.category.Category;
import microservices.topic.domain.model.topic.Status;
import microservices.topic.domain.model.topic.Topic;

import java.time.Instant;
import java.util.Optional;

@AllArgsConstructor
public class TopicOutput {
    private Topic topic;
    private Category category;

    @NonNull
    public Long getId() {
        return topic.getId();
    }

    public Instant getCreatedAt() {
        return topic.getCreatedAt();
    }

    public Status getStatus() {
        return topic.getStatus();
    }

    public String getSubject() {
        return topic.getSubject();
    }

    public String getDescription() {
        return topic.getDescription();
    }

    public boolean isSolved() {
        return topic.isSolved();
    }

    public Category getCategory() {
        return category;
    }
}
