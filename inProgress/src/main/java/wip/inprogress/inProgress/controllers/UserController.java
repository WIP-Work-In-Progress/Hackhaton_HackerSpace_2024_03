package wip.inprogress.inProgress.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wip.inprogress.inProgress.objects.UserDTO;
import wip.inprogress.inProgress.services.UserService;
import wip.inprogress.inProgress.requests.UserPreferencesRequest;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/matching")
    public ResponseEntity<List<UserDTO>> getMatchingUsers(){
        return ResponseEntity.ok(userService.getAllMatches().stream().map(UserDTO::from).collect(Collectors.toList()));
    }

    @GetMapping("/notMatching")
    public ResponseEntity<List<UserDTO>> getNotMatchingUsers(){
        return ResponseEntity.ok(userService.getAllNotMatches().stream().map(UserDTO::from).collect(Collectors.toList()));
    }

    @PostMapping("/preferences/set")
    public ResponseEntity<String> setPreferences(Principal principal, @RequestBody UserPreferencesRequest userPreferencesRequest){
        if (userPreferencesRequest.getMinAge() < 0 || userPreferencesRequest.getMaxAge() < 0) {
            return ResponseEntity.badRequest().body("Age cannot be negative");
        }
        if (userPreferencesRequest.getPreferences().isEmpty()) {
            return ResponseEntity.badRequest().body("Preferences cannot be empty");
        }
        userService.setPreferences(principal.getName(), userPreferencesRequest.getMinAge(), userPreferencesRequest.getMaxAge(), userPreferencesRequest.getPreferences());
        return ResponseEntity.ok().build();
    }


}
