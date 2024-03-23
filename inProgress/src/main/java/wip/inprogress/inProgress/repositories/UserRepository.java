package wip.inprogress.inProgress.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import wip.inprogress.inProgress.models.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends Neo4jRepository<UserEntity, String> {
    @Query("MATCH (u:User {username: $username})" +
            "OPTIONAL MATCH (u)-[r:IS_MENTEE]->(n:Mentee)" +
            " RETURN u, r, n")
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);

    @Query("MATCH (u:User)-[:MATCH]->(m:User) RETURN u")
    List<UserEntity> findAllByMatches();

    @Query("MATCH (u:User)-[:NOT_MATCH]->(n:User) RETURN u")
    List<UserEntity> findAllByNotMatches();

    @Query("MATCH (u:User {username: $username}) " +
           "MATCH (m:User {username: $mentorUsername}) " +
           "MERGE (u)-[:MATCH]->(m)")
    void match(String username, String mentorUsername);

    @Query("MATCH (u:User {username: $username}) " +
           "MATCH (m:User {username: $mentorUsername}) " +
           "MERGE (u)-[:NOT_MATCH]->(m)")
    void notMatch(String username, String mentorUsername);

    @Query("MATCH (u:USER)-[:MENTOR]->(m:MENTOR {id: $mentorId}) RETURN u")
    UserEntity getUserEntityFromMentorId(UUID mentorId);
}
