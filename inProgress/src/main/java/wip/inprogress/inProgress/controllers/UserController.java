package wip.inprogress.inProgress.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wip.inprogress.inProgress.objects.UserDTO;
import wip.inprogress.inProgress.services.UserService;

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
    public ResponseEntity<Void> setPreferences(Principal principal){
        userService.setPreferences(principal.getName(), 25, List.of("Programming"));
        return ResponseEntity.ok().build();
    }


}
