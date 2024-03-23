package wip.inprogress.inProgress.objects;

import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.models.UserEntity;

import java.util.List;
import java.util.stream.Collectors;


public record UserDTO(String firstName, String lastName, Integer minAge, Integer maxAge, List<String> experiences){
    public static UserDTO from(UserEntity user) {
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getMinAge(),
                user.getMaxAge(), user.getExperiences().stream().map(Experience::getName).collect(Collectors.toList()));
    }
}
