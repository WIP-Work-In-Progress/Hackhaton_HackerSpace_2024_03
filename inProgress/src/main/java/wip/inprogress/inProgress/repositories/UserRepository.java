package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import wip.inprogress.inProgress.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Neo4jRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);

    @Query("MATCH (u:User)-[:HAS]->(e:Experience { name: $experienceName }) RETURN u, e")
    List<UserEntity> findUserEntitiesByExperiencesName(String experienceName);
}
