package wip.inprogress.inProgress.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wip.inprogress.inProgress.models.UserEntity;
import wip.inprogress.inProgress.responses.MentorResponse;
import wip.inprogress.inProgress.services.MentorService;

import java.util.List;

@RestController
@RequestMapping("api/mentor")
public class MentorController {
    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping("")
    List<MentorResponse> get(@RequestParam String experience) {
        List<UserEntity> mentors = mentorService.getMentorsByExperience(experience);

        return mentors.stream().map(mentor -> MentorResponse.builder()
                .username(mentor.getUsername())
                .experiences(mentor.getExperiences())
                .build()).toList();
    }
}
