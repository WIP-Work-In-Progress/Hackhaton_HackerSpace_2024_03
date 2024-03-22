package wip.inprogress.inProgress.models;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Getter
@Node
public class Mentor {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    @Relationship(type = "HAS")
    private List<Experience> experiences;

    private Mentor() {
    }

    public Mentor(String firstName, String lastName, List<Experience> experiences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experiences = experiences;
    }
}
