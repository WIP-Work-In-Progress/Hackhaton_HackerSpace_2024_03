package wip.inprogress.inProgress.objects;

import wip.inprogress.inProgress.models.Experience;
import wip.inprogress.inProgress.models.Mentor;
import wip.inprogress.inProgress.models.UserEntity;

import java.util.List;

public record MentorDTO(String firstName, String lastName, Integer age, List<Experience> experiences){
    public static MentorDTO from(UserEntity user) {
        Mentor mentor = user.getMentor();
        return new MentorDTO(user.getFirstName(), user.getLastName(), mentor.getAge(), mentor.getExperiences());
    }
}
