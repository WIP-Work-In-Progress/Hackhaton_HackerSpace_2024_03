package wip.inprogress.inProgress.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Node
public class Mentee {
    @Id @GeneratedValue
    private UUID id;
    private int min_age;
    private int max_age;
    @Relationship(type = "LOOKS_FOR")
    private List<Skill> skills;


}
