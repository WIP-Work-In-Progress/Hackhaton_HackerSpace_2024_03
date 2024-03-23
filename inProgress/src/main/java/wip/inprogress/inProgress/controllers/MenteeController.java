package wip.inprogress.inProgress.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wip.inprogress.inProgress.models.UserEntity;
import wip.inprogress.inProgress.requests.UserPreferencesRequest;
import wip.inprogress.inProgress.services.MenteeService;
import wip.inprogress.inProgress.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("api/mentee")
public class MenteeController {
    private final MenteeService menteeService;
    private final UserService userService;

    public MenteeController(MenteeService menteeService, UserService userService) {
        this.menteeService = menteeService;
        this.userService = userService;
    }

    @PostMapping("/preferences/set")
    public ResponseEntity<String> setPreferences(Principal principal, @RequestBody UserPreferencesRequest userPreferencesRequest){
        if (userPreferencesRequest.getMinAge() < 0 || userPreferencesRequest.getMaxAge() < 0) {
            return ResponseEntity.badRequest().body("Age cannot be negative");
        }
        if (userPreferencesRequest.getPreferences().isEmpty()) {
            return ResponseEntity.badRequest().body("Preferences cannot be empty");
        }
        UserEntity user = userService.getUserByUsername(principal.getName());
        menteeService.setPreferences(user.getMentor().getId(), userPreferencesRequest.getMinAge(),
                userPreferencesRequest.getMaxAge(), userPreferencesRequest.getPreferences());
        return ResponseEntity.ok().build();
    }

}
