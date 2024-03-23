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
public class Mentee {
    @Id @GeneratedValue
    private UUID id;
    private int minAge;
    private int maxAge;
    @Relationship(type = "LOOKS_FOR")
    private List<Skill> skills;


}
