package observerPattern.StateTask;

public class MainTest {
    public static void main(String[] args) {
        TaskState task = new TaskState("Task 1", "Begin Task");
        ObserverTeamMember observer1 = new TeamMember("John");
        ObserverTeamMember observer2 = new TeamMember("Doe");

        task.Attach(observer1);
        task.Attach(observer2);
        task.Notify();
        System.out.println("Task name: " + task.getTaskName());
        task.setTaskState("In Progress");
        System.out.println("=====================================");
        task.setTaskState("Conflict");
        System.out.println("=====================================");
        task.setTaskState("Done resolving conflict");
        System.out.println("=====================================");
        task.setTaskState("Review task");
    }
}
