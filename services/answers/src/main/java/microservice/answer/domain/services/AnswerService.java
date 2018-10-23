package microservice.answer.domain.services;

import microservice.answer.application.dtos.AnswerOutput;
import microservice.answer.domain.dtos.Topic;
import microservice.answer.domain.dtos.User;
import microservice.answer.domain.models.Answer;
import microservice.answer.domain.repositories.Answers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    private final Answers answers;
    private final TopicService topicService;
    private final UserService userService;

    public AnswerService(Answers answers, TopicService topicService, UserService userService) {
        this.answers = answers;
        this.topicService = topicService;
        this.userService = userService;
    }


    public List<AnswerOutput> listAll(){
        return answers.findAll().stream().map(this::toAnswerOutput).collect(Collectors.toList());
    }

    public Optional<AnswerOutput> loadBy(Long id){
        return answers.findById(id).map(this::toAnswerOutput);
    }

    private AnswerOutput toAnswerOutput(Answer answer){
        Topic topic = topicService.getBy(answer);
        User user = userService.getBy(answer);

        return new AnswerOutput(answer,topic, user);
    }
}
