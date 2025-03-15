package observerPattern.Stock;

public class EmailInvestor implements  ObserverInvestor{
    private Investor investor;
    private String email;

    public EmailInvestor(Investor investor, String email) {
        this.investor = investor;
        this.email = email;
    }
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("send email to "+ investor.getName() + " at " + email + " : " + stockName + " price change to " + stockPrice);
    }
}
