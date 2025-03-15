package observerPattern.StateTask;

public class TeamMember implements ObserverTeamMember {
    private String name;

    public TeamMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String taskName, String taskState) {
        System.out.println("Team member " + name + " has been notified about the task " + taskName + " with state " + taskState);
    }
}
