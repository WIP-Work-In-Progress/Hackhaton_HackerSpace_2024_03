package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import wip.inprogress.inProgress.models.UserEntity;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
}
