package wip.inprogress.inProgress.models;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

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

    @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
    private List<Experience> experiences;

    public boolean isAdmin() {
        return roles.contains("ADMIN");
    }

}
