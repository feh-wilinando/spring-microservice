package microservice.answer.application.dtos;

import lombok.NonNull;
import microservice.answer.domain.dtos.Topic;
import microservice.answer.domain.dtos.User;
import microservice.answer.domain.models.Answer;

public class AnswerOutput {
    private final Answer answer;
    private final Topic topic;
    private final User user;

    public AnswerOutput(Answer answer, Topic topic, User user) {
        this.answer = answer;
        this.topic = topic;
        this.user = user;
    }


    public Long getId() {
        return answer.getId();
    }


    @NonNull
    public String getContent() {
        return answer.getContent();
    }

    public Topic getTopic() {
        return topic;
    }

    public User getUser() {
        return user;
    }
}
