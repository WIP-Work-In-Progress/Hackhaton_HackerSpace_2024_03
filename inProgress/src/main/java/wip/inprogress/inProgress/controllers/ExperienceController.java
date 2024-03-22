package wip.inprogress.inProgress.controllers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.repositories.ExperienceRepository;
import wip.inprogress.inProgress.requests.ExperienceRequest;
import wip.inprogress.inProgress.services.ExperienceService;

import java.util.Optional;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    private final ExperienceService experienceService;


    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/{name}")
    ResponseEntity<Experience> Get(@PathVariable String name) {
        Optional<Experience> experience = experienceService.findByName(name);

        return experience.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    ExperienceRequest Create(@RequestBody ExperienceRequest experienceRequest) {
        experienceService.create(experienceRequest.getName());
        return experienceRequest;
    }
}
