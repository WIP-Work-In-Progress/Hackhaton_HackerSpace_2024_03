package wip.inprogress.inProgress.requests;

import lombok.Getter;

import java.util.List;

@Getter
public class UserPreferencesRequest {
    private Integer minAge;
    private Integer maxAge;
    private List<String> preferences;
}
