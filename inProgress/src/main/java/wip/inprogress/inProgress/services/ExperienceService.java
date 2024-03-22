package wip.inprogress.inProgress.services;

import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.repositories.ExperienceRepository;
import wip.inprogress.inProgress.requests.ExperienceRequest;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public Experience findByName(String name) {
        return experienceRepository.findExperienceByName(name);
    }

    public void create(String experienceName) {
        experienceRepository.createExperience(experienceName);
    }
}
