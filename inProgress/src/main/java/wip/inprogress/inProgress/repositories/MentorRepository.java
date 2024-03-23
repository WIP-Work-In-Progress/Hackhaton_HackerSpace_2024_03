package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import wip.inprogress.inProgress.models.Mentor;

import java.util.List;
import java.util.UUID;

public interface MentorRepository extends Neo4jRepository<Mentor, UUID> {
    @Query("MATCH (u:Mentor {id: $id}) " +
            "SET u.age = $age " +
            "WITH u " +
            "UNWIND $experiences as experienceName " +
            "MATCH (e:Experience {name: experienceName}) " +
            "MERGE (u)-[:HAS]->(e)")
    void setPreferences(UUID id, Integer age, List<String> experiences);

    @Query("MATCH (u:Mentor)-[:HAS]->(e:Experience) WHERE u.age >= $minAge AND u.age <= $maxAge AND e.name IN $experiences RETURN u")
    List<Mentor> findAllByAgeBetweenAndExperiences(Integer minAge, Integer maxAge, List<String> skills);

    @Query("MATCH (u:Mentor)-[:HAS]->(e:SKill) WHERE e.name IN $experiences RETURN u")
    List<Mentor> findAllByExperiences(List<String> skills);

    List<Mentor> findALlByAgeBetween(Integer minAge, Integer maxAge);
}
