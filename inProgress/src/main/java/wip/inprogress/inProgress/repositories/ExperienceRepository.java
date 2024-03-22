package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import wip.inprogress.inProgress.models.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceRepository extends Neo4jRepository<Experience, String> {
    @Query("CREATE (:Experience { name: $name })")
    void createExperience(String name);
    Optional<Experience> findExperienceByName(String name);
    @Query("MATCH (e:Experience) RETURN e")
    List<Experience> findExperiences();
    void deleteByName(String name);
    @Query("MATCH (e:Experience { name: $oldName }) SET e.name = $newName")
    void updateByName(String oldName, String newName);
}
