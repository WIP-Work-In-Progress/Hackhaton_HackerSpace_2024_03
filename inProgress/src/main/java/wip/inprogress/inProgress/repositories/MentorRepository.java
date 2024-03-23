package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.models.Mentor;
import wip.inprogress.inProgress.objects.SkillWithExperience;

import java.util.List;
import java.util.UUID;

public interface MentorRepository extends Neo4jRepository<Mentor, UUID> {
    @Query("MATCH (u:Mentor {id: $id}) " +
            "SET u.age = $age " +
            "WITH u " +
            "UNWIND $experiences as experience " +
            "MATCH (e:Experience {name: experience.name}) " +
            "MERGE (u)-[:HAS {year: experience.years_of_experience}]->(e)")
    void setPreferences(UUID id, Integer age, List<SkillWithExperience> experiences);

    List<Mentor> findAllByAgeBetweenAndExperiences(Integer minAge, Integer maxAge, List<Experience> experiences);

    List<Mentor> findAllByExperiences(List<Experience> experiences);
}
