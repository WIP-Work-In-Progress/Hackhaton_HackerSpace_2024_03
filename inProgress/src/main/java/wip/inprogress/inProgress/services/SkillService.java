package wip.inprogress.inProgress.services;

import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.models.Skill;
import wip.inprogress.inProgress.repositories.SkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    public Optional<Skill> findByName(String name) {
        return skillRepository.findSkillByName(name);
    }

    public void create(String skillName) {
        skillRepository.createSkill(skillName);
    }

    public void update(String oldSkillName, String newSkillName) {
        skillRepository.updateByName(oldSkillName, newSkillName);
    }

    public void delete(String skillName) {
        skillRepository.deleteByName(skillName);
    }
}
