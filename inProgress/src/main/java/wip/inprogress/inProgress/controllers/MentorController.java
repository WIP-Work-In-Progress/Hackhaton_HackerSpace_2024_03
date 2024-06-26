package wip.inprogress.inProgress.controllers;

import org.springframework.web.bind.annotation.*;
import wip.inprogress.inProgress.models.Mentee;
import wip.inprogress.inProgress.models.Mentor;
import wip.inprogress.inProgress.models.Skill;
import wip.inprogress.inProgress.models.UserEntity;
import wip.inprogress.inProgress.objects.MentorDTO;
import wip.inprogress.inProgress.requests.MentorRequest;
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
    List<MentorDTO> get(@RequestParam(defaultValue = "0") int minAge, @RequestParam(defaultValue = "0") int maxAge,
                        @RequestParam(defaultValue = "") String experience) {

        if (Objects.equals(experience, "")) {
            return mentorService.getMentorsByAge(minAge, maxAge).stream().map(mentor -> {
                UserEntity user = userService.getUserEntityFromMentorId(mentor.getId());
                return new MentorDTO(user.getFirstName(), user.getLastName(), mentor.getAge(), mentor.getSkills());
            }).toList();
        }

        List<String> experienceNames = Arrays.asList(experience.split(","));

        List<Mentor> mentors = mentorService.getMentorsByAgeAndExperience(minAge, maxAge, experienceNames);

        return mentors.stream().map(mentor -> {
            UserEntity user = userService.getUserEntityFromMentorId(mentor.getId());
            return new MentorDTO(user.getFirstName(), user.getLastName(), mentor.getAge(), mentor.getSkills());
        }).toList();
    }

    @GetMapping("/preferences")
    List<MentorDTO> get(Principal principal) {
        Mentee user = userService.getUserByUsername(principal.getName()).getMentee();
        List<Mentor> mentors = mentorService.getMentorsByAgeAndExperience(user.getMinAge(), user.getMaxAge(),
                user.getSkills().stream().map(Skill::getName).toList());

        return mentors.stream().map(mentor -> {
            UserEntity mentorUser = userService.getUserEntityFromMentorId(mentor.getId());
            return new MentorDTO(mentorUser.getFirstName(), mentorUser.getLastName(), mentor.getAge(), mentor.getSkills());
        }).toList();
    }

    //TODO set preferences skills and age
    @PostMapping("/preferences/set")
    public void setPreferences(Principal principal, @RequestBody MentorRequest mentorRequest) {
        mentorService.setPreferences(principal.getName(), mentorRequest.age(), mentorRequest.skillNames());
    }
}
