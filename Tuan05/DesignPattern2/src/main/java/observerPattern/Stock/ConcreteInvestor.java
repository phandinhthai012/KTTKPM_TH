package observerPattern.Stock;

public class ConcreteInvestor implements ObserverInvestor{
    private Investor investor;

    public ConcreteInvestor(Investor investor) {
        this.investor = investor;
    }
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(investor.getName()+ ":"+ stockName + " price change to " + stockPrice);
    }
}
