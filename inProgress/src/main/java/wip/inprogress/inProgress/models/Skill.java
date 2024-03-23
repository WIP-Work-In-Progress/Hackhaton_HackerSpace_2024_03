package wip.inprogress.inProgress.models;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Node
public class Skill {
    @Id
    private String name;

    private Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }
}
