package wip.inprogress.inProgress.services;

import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.models.UserEntity;
import wip.inprogress.inProgress.repositories.UserRepository;

import java.util.List;


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

    public void setPreferences(String username, Integer age, List<String> experiences) {
        userRepository.setPreferences(username, age, experiences);
    }
}
