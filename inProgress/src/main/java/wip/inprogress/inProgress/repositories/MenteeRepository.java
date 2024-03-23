package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.UUID;

public interface MenteeRepository extends Neo4jRepository<MenteeRepository, UUID> {
    @Query("MATCH (u:Mentee {id: $id}) " +
            "SET u.minAge = $minAge, u.maxAge = $maxAge " +
            "WITH u " +
            "UNWIND $experiences as experienceName " +
            "MATCH (e:Experience {name: experienceName}) " +
            "MERGE (u)-[:LOOKS_FOR]->(e)")
    void setPreferences(UUID id, Integer minAge, Integer maxAge, List<String> experiences);
    // TODO: Fix query
}
