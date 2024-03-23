package wip.inprogress.inProgress.services;

import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.models.Mentor;
import wip.inprogress.inProgress.repositories.MentorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
    private final MentorRepository mentorRepository;

    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public List<Mentor> getMentorsByAgeAndExperience(int minAge, int maxAge, List<String> skillNames) {
        return mentorRepository.findAllByAgeBetweenAndExperiences(minAge, maxAge, skillNames);
    }

    public List<Mentor> getMentorsByExperience(List<String> skillNames){
        return mentorRepository.findAllByExperiences(skillNames);
    }

    public List<Mentor> getMentorsByAge(int minAge, int maxAge) {
        return mentorRepository.findALlByAgeBetween(minAge, maxAge);
    }
}
