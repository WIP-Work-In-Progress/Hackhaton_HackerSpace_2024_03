package wip.inprogress.inProgress.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.repositories.ExperienceRepository;
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
}
