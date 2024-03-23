package wip.inprogress.inProgress.services;

import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.models.UserEntity;
import wip.inprogress.inProgress.repositories.UserRepository;

import java.util.List;
import java.util.UUID;


@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    public List<UserEntity> getAllMatches() {
        return userRepository.findAllByMatches();
    }
    public List<UserEntity> getAllNotMatches() {
        return userRepository.findAllByNotMatches();
    }

    public void match(String username, String mentorUsername) {
        userRepository.match(username, mentorUsername);
    }

    public void notMatch(String username, String mentorUsername) {
        userRepository.notMatch(username, mentorUsername);
    }

    public void becomeMentor(String username) {
        userRepository.becomeMentor(username);
    }

    public void becomeMentee(String username) {
        userRepository.becomeMentee(username);
    }

    public UserEntity getUserEntityFromMentorId(UUID mentorId) {
        return userRepository.getUserEntityFromMentorId(mentorId);
    }
}
