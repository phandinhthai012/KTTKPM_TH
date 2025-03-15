package observerPattern.StateTask;

import java.util.ArrayList;
import java.util.List;

public class TaskState implements SubjectTask {
    private String taskName;
    private String taskState;
    private List<ObserverTeamMember> observerTeamMember= new ArrayList<>() ;

    public TaskState(String taskName, String taskState) {
        this.taskName = taskName;
        this.taskState = taskState;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
        Notify();
    }

    @Override
    public void Attach(ObserverTeamMember observerTeamMember) {
        if (!this.observerTeamMember.contains(observerTeamMember)) {
            this.observerTeamMember.add(observerTeamMember);
        }
    }

    @Override
    public void Detach(ObserverTeamMember observerTeamMember) {
        this.observerTeamMember.remove(observerTeamMember);
    }

    @Override
    public void Notify() {
        for (ObserverTeamMember observer : observerTeamMember) {
            observer.update(taskName, taskState);
        }
    }
}
