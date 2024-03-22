package wip.inprogress.inProgress.models;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node("User")
public class UserEntity {
    @Id
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String roles;

    public boolean isAdmin() {
        return roles.contains("ADMIN");
    }

}
