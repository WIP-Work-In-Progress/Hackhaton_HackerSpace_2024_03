package wip.inprogress.inProgress.models;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Node
public class Experience {
    @Id
    private String name;

    private Experience() {
    }

    public Experience(String name) {
        this.name = name;
    }
}
