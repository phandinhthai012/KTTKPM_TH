package observerPattern.Stock;

import java.util.ArrayList;
import java.util.List;

public class ConcreteStock implements SubjectStock{
    private String stockName;
    private double stockPrice;
    private List<ObserverInvestor> investors = new ArrayList<>();


    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        Notify();
    }

    public ConcreteStock(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }
    @Override
    public void Attach(ObserverInvestor observerInvestor) {
        if(!investors.contains(observerInvestor)){
            investors.add(observerInvestor);
        }
    }

    @Override
    public void Detach(ObserverInvestor observerInvestor) {
        investors.remove(observerInvestor);
    }

    @Override
    public void Notify() {
        for(ObserverInvestor investor: investors){
            investor.update(stockName, stockPrice);
        }
    }
}
