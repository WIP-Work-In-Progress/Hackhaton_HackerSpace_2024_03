package wip.inprogress.inProgress.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.repositories.ExperienceRepository;
import wip.inprogress.inProgress.requests.ExperienceRequest;
import wip.inprogress.inProgress.services.ExperienceService;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    private final ExperienceService experienceService;


    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/{name}")
    Experience Get(@PathVariable String name) {
        return experienceService.findByName(name);
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    ExperienceRequest Create(@RequestBody ExperienceRequest experienceRequest) {
        experienceService.create(experienceRequest.getName());
        return experienceRequest;
    }
}
