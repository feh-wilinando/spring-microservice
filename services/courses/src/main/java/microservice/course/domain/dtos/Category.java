package microservice.course.domain.dtos;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Category {
    private Long id;
    @NonNull
    private String name;
}
