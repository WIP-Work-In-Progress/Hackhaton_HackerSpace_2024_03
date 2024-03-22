package wip.inprogress.inProgress.services;

import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.repositories.ExperienceRepository;
import wip.inprogress.inProgress.requests.ExperienceRequest;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> findByName(String name) {
        return experienceRepository.findExperienceByName(name);
    }

    public void create(String experienceName) {
        experienceRepository.createExperience(experienceName);
    }

    public void update(String oldExperienceName, String newExperienceName) {
        experienceRepository.updateByName(oldExperienceName, newExperienceName);
    }

    public void delete(String experienceName) {
        experienceRepository.deleteByName(experienceName);
    }
}
