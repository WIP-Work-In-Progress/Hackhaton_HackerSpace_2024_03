package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Neo4jRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);

    @Query("MATCH (u:User)-[:MATCH]->(m:User) RETURN u")
    List<UserEntity> findAllByMatches();

    @Query("MATCH (u:User)-[:NOT_MATCH]->(n:User) RETURN u")
    List<UserEntity> findAllByNotMatches();

    @Query("MATCH (u:User {username: $username}) " +
           "SET u.age = $age " +
            "WITH u " +
           "UNWIND $experiences as experienceName " +
           "MATCH (e:Experience {name: experienceName}) " +
           "MERGE (u)-[:HAS]->(e)")
    void setPreferences(String username, Integer age, List<String> experiences);
    @Query("MATCH (u:User)-[r:HAS]->(e:Experience { name: $experienceName }) RETURN u, r, e")
    List<UserEntity> findUserEntitiesByExperiencesName(String experienceName);
}
