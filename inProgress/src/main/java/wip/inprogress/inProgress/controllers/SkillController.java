package wip.inprogress.inProgress.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wip.inprogress.inProgress.models.Skill;
import wip.inprogress.inProgress.requests.SkillRequest;
import wip.inprogress.inProgress.services.SkillService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skill")
public class SkillController {
    private final SkillService skillService;


    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("")
    List<Skill> Get() {
        return skillService.getAll();
    }

    @GetMapping("/{name}")
    ResponseEntity<Skill> Get(@PathVariable String name) {
        Optional<Skill> skill = skillService.findByName(name);

        return skill.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    SkillRequest Create(@RequestBody SkillRequest skillRequest) {
        skillService.create(skillRequest.getName());
        return skillRequest;
    }

    @PutMapping("/{name}")
    ResponseEntity<SkillRequest> Update(@PathVariable String name, @RequestBody SkillRequest skillRequest) {
        Optional<Skill> skill = skillService.findByName(name);

        if (skill.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        skillService.update(name, skillRequest.getName());
        return ResponseEntity.ok(skillRequest);
    }

    @DeleteMapping("/{name}")
    ResponseEntity<Void> Delete(@PathVariable String name) {
        Optional<Skill> skill = skillService.findByName(name);

        if (skill.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        skillService.delete(name);
        return ResponseEntity.noContent().build();
    }
}
