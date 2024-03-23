package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.UUID;

public interface MentorRepository {
    @Query("MATCH (u:Mentor {id: $id}) " +
            "SET u.age = $age " +
            "WITH u " +
            "UNWIND $experiences as experienceName " +
            "MATCH (e:Experience {name: experienceName}) " +
            "MERGE (u)-[:HAS]->(e)")
    void setPreferences(UUID id, Integer age, List<String> experiences);
}
