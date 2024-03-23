package wip.inprogress.inProgress.models;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Data
@Node
public class Mentor {
    @Id @GeneratedValue
    private UUID id;
    private Integer age;
    @Relationship(type = "HAS")
    private List<Experience> experiences;
}
