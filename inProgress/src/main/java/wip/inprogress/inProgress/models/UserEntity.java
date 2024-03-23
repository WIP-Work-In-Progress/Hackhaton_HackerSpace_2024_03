package wip.inprogress.inProgress.models;

import lombok.*;
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
    private Integer minAge;
    private Integer maxAge;

    @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
    private List<Skill> skills;

    @Relationship(type = "MATCH")
    private List<UserEntity> matches;

    @Relationship(type = "NOT_MATCH")
    private List<UserEntity> notMatches;

    public boolean isAdmin() {
        return roles.contains("ADMIN");
    }

}
