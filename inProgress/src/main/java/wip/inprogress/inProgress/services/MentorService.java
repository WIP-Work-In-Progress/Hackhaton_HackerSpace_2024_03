package wip.inprogress.inProgress.services;

import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.models.Mentor;
import wip.inprogress.inProgress.models.UserEntity;
import wip.inprogress.inProgress.repositories.ExperienceRepository;
import wip.inprogress.inProgress.repositories.MentorRepository;
import wip.inprogress.inProgress.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorService {
    private final MentorRepository mentorRepository;
    private final ExperienceRepository experienceRepository;

    public MentorService(MentorRepository mentorRepository, ExperienceRepository experienceRepository) {
        this.mentorRepository = mentorRepository;
        this.experienceRepository = experienceRepository;
    }

    public List<Mentor> getMentorsByAgeAndExperience(int minAge, int maxAge, List<String> experienceNames) {
        List<Experience> experiences = experienceNames.stream().map(
                experienceName -> {
                    Optional<Experience> experience = experienceRepository.findExperienceByName(experienceName);
                    if (experience.isEmpty()) {
                        throw new IllegalArgumentException("Experience not found: " + experienceName);
                    }
                    return experience.get();
                }
        ).toList();

        return mentorRepository.findAllByAgeBetweenAndExperiences(minAge, maxAge, experiences);
    }

    public List<Mentor> getMentorsByExperience(List<String> experienceNames){
        List<Experience> experiences = experienceNames.stream().map(
                experienceName -> {
                    Optional<Experience> experience = experienceRepository.findExperienceByName(experienceName);
                    if (experience.isEmpty()) {
                        throw new IllegalArgumentException("Experience not found: " + experienceName);
                    }
                    return experience.get();
                }
        ).toList();

        return mentorRepository.findAllByExperiences(experiences);
    }

}
