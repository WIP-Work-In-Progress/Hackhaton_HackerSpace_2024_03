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



    @Query("MATCH (u:User) WHERE u.age >= $minAge AND u.age <= $maxAge RETURN u")
    List<UserEntity> findUserEntitiesByAge(int minAge, int maxAge);

    @Query("MATCH (u:User)-[r:HAS]->(e:Experience) WHERE u.age >= $minAge AND u.age <= $maxAge AND e.name IN $experiences RETURN u, r, e")
    List<UserEntity> findUserEntitiesByAgeAndExperiences(int minAge, int maxAge, List<String> experiences);

    @Query("MATCH (u:User {username: $username}) " +
           "MATCH (m:User {username: $mentorUsername}) " +
           "MERGE (u)-[:MATCH]->(m)")
    void match(String username, String mentorUsername);

    @Query("MATCH (u:User {username: $username}) " +
           "MATCH (m:User {username: $mentorUsername}) " +
           "MERGE (u)-[:NOT_MATCH]->(m)")
    void notMatch(String username, String mentorUsername);
}
