package wip.inprogress.inProgress.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wip.inprogress.inProgress.models.Skill;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MentorResponse {
    private String username;
    private List<Skill> skills;
}
