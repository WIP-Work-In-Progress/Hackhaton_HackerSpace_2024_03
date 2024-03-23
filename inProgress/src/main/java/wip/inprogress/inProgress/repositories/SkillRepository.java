package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import wip.inprogress.inProgress.models.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends Neo4jRepository<Skill, String> {
    @Query("CREATE (:Skill { name: $name })")
    void createSkill(String name);
    Optional<Skill> findSkillByName(String name);
    @Query("MATCH (e:Skill) RETURN e")
    List<Skill> findSkills();
    void deleteByName(String name);
    @Query("MATCH (e:Skill { name: $oldName }) SET e.name = $newName")
    void updateByName(String oldName, String newName);
}
