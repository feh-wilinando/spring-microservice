package microservice.topic.application.dtos;

import lombok.NonNull;
import microservice.topic.domain.dtos.Category;
import microservice.topic.domain.dtos.User;
import microservice.topic.domain.models.Status;
import microservice.topic.domain.models.Topic;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TopicOutput {
    private final Topic topic;
    private final Category category;
    private final User user;

    public TopicOutput(Topic topic, Category category, User user) {
        this.topic = topic;
        this.category = category;
        this.user = user;
    }


    public Long getId() {
        return topic.getId();
    }

    @NonNull
    public String getShortDescription() {
        return topic.getShortDescription();
    }

    @NonNull
    public String getContent() {
        return topic.getContent();
    }

    @NonNull
    public Status getStatus() {
        return topic.getStatus();
    }

    @NonNull
    public Instant getCreatedAt() {
        return topic.getCreatedAt();
    }

    public long getOpenSince(){
            return topic.getCreatedAt().until(Instant.now(), ChronoUnit.MILLIS);
    }

    public boolean isSolved() {
        return topic.isSolved();
    }

    @NonNull
    public String getCategoryName() {
        return category.getName();
    }

    @NonNull
    public String getUsername() {
        return user.getName();
    }

    @NonNull
    public String getEmail() {
        return user.getEmail();
    }
}
