package microservices.users.application.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserForm {

    private String name;
    private String email;

}
