package wip.inprogress.inProgress.models;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class Mentor {
    private int age;
    @Relationship(type = "HAS")
    private List<Experience> experiences;
}
