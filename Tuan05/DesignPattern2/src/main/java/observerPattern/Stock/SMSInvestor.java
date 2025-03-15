package observerPattern.Stock;

import java.security.PrivateKey;

public class SMSInvestor implements ObserverInvestor{
    private Investor investor;
    private String phoneNumber;

    public SMSInvestor(Investor investor, String phoneNumber) {
        this.investor = investor;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("send SMS to "+ investor.getName() + " at " + phoneNumber + " : " + stockName + " price change to " + stockPrice);
    }
}
