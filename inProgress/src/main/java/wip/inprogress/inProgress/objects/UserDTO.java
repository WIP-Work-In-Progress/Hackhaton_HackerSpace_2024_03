package wip.inprogress.inProgress.objects;

import wip.inprogress.inProgress.models.UserEntity;


public record UserDTO(String firstName, String lastName) {
    public static UserDTO from(UserEntity user) {
        return new UserDTO(user.getFirstName(), user.getLastName());
    }
}
