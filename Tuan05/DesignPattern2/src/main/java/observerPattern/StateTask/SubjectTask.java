package observerPattern.StateTask;

public interface SubjectTask {
    void Attach(ObserverTeamMember observerTeamMember);
    void Detach(ObserverTeamMember observerTeamMember);
    void Notify();

}
