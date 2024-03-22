package wip.inprogress.inProgress.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wip.inprogress.inProgress.repositories.UserRepository;
import wip.inprogress.inProgress.models.SecurityUser;

@Service
public class Neo4jUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public Neo4jUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
