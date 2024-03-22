package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import wip.inprogress.inProgress.models.Experience;

public interface ExperienceRepository extends Neo4jRepository<Experience, String> {
    @Query("CREATE (:Experience { name: $name })")
    void createExperience(String name);
    Experience findExperienceByName(String name);
}
