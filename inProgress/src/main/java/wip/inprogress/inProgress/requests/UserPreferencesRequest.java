package wip.inprogress.inProgress.requests;

import lombok.Getter;

import java.util.List;

@Getter
public class UserPreferencesRequest {
    private Integer age;
    private List<String> preferences;
}
