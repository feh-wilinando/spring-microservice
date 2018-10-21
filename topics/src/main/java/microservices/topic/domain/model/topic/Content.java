package microservices.topic.domain.model.topic;

import lombok.Value;

@Value
public class Content {
    private String subject;
    private String description;
}
