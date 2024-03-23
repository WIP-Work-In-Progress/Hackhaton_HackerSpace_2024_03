package wip.inprogress.inProgress.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wip.inprogress.inProgress.models.UserEntity;
import wip.inprogress.inProgress.responses.MentorResponse;
import wip.inprogress.inProgress.services.MentorService;
import wip.inprogress.inProgress.services.UserService;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/mentor")
public class MentorController {
    private final MentorService mentorService;
    private final UserService userService;

    public MentorController(MentorService mentorService, UserService userService) {
        this.mentorService = mentorService;
        this.userService = userService;
    }

    @GetMapping("")
    List<MentorResponse> get(@RequestParam(defaultValue = "0") int minAge, @RequestParam(defaultValue = "0") int maxAge,
                             @RequestParam(defaultValue = "") String experience) {

        if (Objects.equals(experience, "")) {
            return mentorService.getMentorsByAge(minAge, maxAge).stream().map(mentor -> MentorResponse.builder()
                    .username(mentor.getUsername())
                    .skills(mentor.getSkills())
                    .build()).toList();
        }

        List<String> experienceNames = Arrays.asList(experience.split(","));

        List<UserEntity> mentors = mentorService.getMentorsByAgeAndExperience(minAge, maxAge, experienceNames);

        return MapToMentorResponse(mentors);
    }

    @GetMapping("/preferences")
    List<MentorResponse> get(Principal principal) {
        UserEntity user = userService.getUserByUsername(principal.getName());
        List<UserEntity> mentors = mentorService.getMentorsByAge(user.getMinAge(), user.getMaxAge());

        return MapToMentorResponse(mentors);
    }

    private List<MentorResponse> MapToMentorResponse(List<UserEntity> mentors) {
        return mentors.stream().map(mentor -> MentorResponse.builder()
                .username(mentor.getUsername())
                .skills(mentor.getSkills())
                .build()).toList();
    }
}
