package microservice.topic.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor( access = AccessLevel.PACKAGE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @NonNull
    private String name;
    @NonNull
    private String email;
}

