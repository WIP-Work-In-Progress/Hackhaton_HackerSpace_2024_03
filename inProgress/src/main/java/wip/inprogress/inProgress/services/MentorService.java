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
        //TODO Change skillNames to Skill with experience
        return mentorRepository.findAllByAgeBetweenAndExperiences(minAge, maxAge, skillNames);
    }

    public List<Mentor> getMentorsByAge(int minAge, int maxAge) {
        return mentorRepository.findALlByAgeBetween(minAge, maxAge);
    }

    public void setPreferences(String name, int age, List<String> skillNames) {
        Optional<Mentor> mentor = mentorRepository.findByUsername(name);
        mentor.ifPresent(value -> mentorRepository.setPreferences(value.getId(), age, skillNames));
    }
}
