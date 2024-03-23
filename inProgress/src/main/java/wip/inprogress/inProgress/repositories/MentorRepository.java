package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import wip.inprogress.inProgress.models.Mentor;
import wip.inprogress.inProgress.models.Skill;
import wip.inprogress.inProgress.objects.SkillWithExperience;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MentorRepository extends Neo4jRepository<Mentor, UUID> {
    @Query("MATCH (u:Mentor {id: $id}) " +
            "SET u.age = $age " +
            "WITH u " +
            "UNWIND $skills as skill " +
            "MATCH (e:Experience {name: skill}) " +
            "MERGE (u)-[:HAS]->(e)")
    void setPreferences(UUID id, Integer age, List<String> experiences);

    @Query("MATCH (u:Mentor)-[r:HAS]->(e:Experience) WHERE u.age >= $minAge AND u.age <= $maxAge AND e.name IN $experiences RETURN u, r, e")
    List<Mentor> findAllByAgeBetweenAndExperiences(Integer minAge, Integer maxAge, List<String> skills);

    @Query("MATCH (u:Mentor)-[:HAS]->(e:SKill) WHERE e.name IN $experiences RETURN u")
    List<Mentor> findAllByExperiences(List<String> skills);

    List<Mentor> findALlByAgeBetween(Integer minAge, Integer maxAge);

    @Query("MATCH (u:UserEntity {username: $name})-[:IS_MENTOR]->(m:Mentor) RETURN m")
    Optional<Mentor> findByUsername(String name);
}
