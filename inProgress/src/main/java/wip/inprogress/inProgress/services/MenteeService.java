package wip.inprogress.inProgress.services;

import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.repositories.MenteeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MenteeService {
    private final MenteeRepository menteeRepository;

    public MenteeService(MenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    public void setPreferences(UUID id, Integer minAge, Integer maxAge, List<String> skills) {
        menteeRepository.setPreferences(id, minAge, maxAge, skills);
    }
}
