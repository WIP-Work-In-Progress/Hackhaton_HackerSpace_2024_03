package wip.inprogress.inProgress.services;

import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.models.UserEntity;
import wip.inprogress.inProgress.repositories.UserRepository;

import java.util.List;

@Service
public class MentorService {
    private final UserRepository userRepository;

    public MentorService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getMentorsByAgeAndExperience(int minAge, int maxAge, List<String> experienceNames) {
        return userRepository.findUserEntitiesByAgeAndExperiences(minAge, maxAge, experienceNames);
    }

    public List<UserEntity> getMentorsByAge(int minAge, int maxAge) {
        return userRepository.findUserEntitiesByAge(minAge, maxAge);
    }
}
