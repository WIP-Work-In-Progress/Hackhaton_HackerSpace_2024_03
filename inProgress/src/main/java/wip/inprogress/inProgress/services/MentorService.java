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

    public List<UserEntity> getMentorsByExperience(String experienceName) {
        return userRepository.findUserEntitiesByExperiencesName(experienceName);
    }
}
