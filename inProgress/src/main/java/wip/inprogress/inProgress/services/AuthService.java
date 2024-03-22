package wip.inprogress.inProgress.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.models.UserEntity;
import wip.inprogress.inProgress.repositories.UserRepository;
import wip.inprogress.inProgress.requests.RegisterRequest;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return false;
        }
        var user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .roles("ROLE_USER")
                .build();
        userRepository.save(user);
        return true;
    }
}
