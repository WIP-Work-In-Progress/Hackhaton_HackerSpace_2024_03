package wip.inprogress.inProgress.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wip.inprogress.inProgress.objects.UserDTO;
import wip.inprogress.inProgress.requests.MatchRequest;
import wip.inprogress.inProgress.services.MenteeService;
import wip.inprogress.inProgress.services.UserService;
import wip.inprogress.inProgress.requests.UserPreferencesRequest;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    final private UserService userService;
    private final MenteeService menteeService;

    public UserController(UserService userService, MenteeService menteeService) {
        this.userService = userService;
        this.menteeService = menteeService;
    }

    @PostMapping("/match")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void match(Principal principal, @RequestBody MatchRequest matchRequest) {
        userService.match(principal.getName(), matchRequest.getMentorUsername());
    }

    @PostMapping("/notMatch")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void notMatch(Principal principal, @RequestBody MatchRequest matchRequest) {
        userService.notMatch(principal.getName(), matchRequest.getMentorUsername());
    }

    @GetMapping("/matching")
    public ResponseEntity<List<UserDTO>> getMatchingUsers(){
        return ResponseEntity.ok(userService.getAllMatches().stream().map(UserDTO::from).collect(Collectors.toList()));
    }

    @GetMapping("/notMatching")
    public ResponseEntity<List<UserDTO>> getNotMatchingUsers(){
        return ResponseEntity.ok(userService.getAllNotMatches().stream().map(UserDTO::from).collect(Collectors.toList()));
    }

    @PutMapping("/becomeMentor")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void becomeMentor(Principal principal) {
        userService.becomeMentor(principal.getName());
    }

    @PutMapping("/becomeMentee")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void becomeMentee(Principal principal) {
        userService.becomeMentee(principal.getName());
    }


}
