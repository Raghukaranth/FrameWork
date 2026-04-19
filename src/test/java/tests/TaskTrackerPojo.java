package tests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskTrackerPojo {
    private long id;
    private String task;

    public TaskTrackerPojo(String task) {
        this.task = task;
    }
}
