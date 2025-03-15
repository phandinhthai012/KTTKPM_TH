package observerPattern.Stock;

public interface SubjectStock {
    void Attach(ObserverInvestor observerInvestor);
    void Detach(ObserverInvestor observerInvestor);
    void Notify();
}
