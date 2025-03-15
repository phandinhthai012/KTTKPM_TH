package observerPattern.Stock;

public class MainTestStock {
    public static void main(String[] args) {
        ConcreteStock subjectStock = new ConcreteStock("Stock 1", 100);
        ObserverInvestor observerInvestor1 = new ConcreteInvestor(new Investor("Investor 1"));
        ObserverInvestor observerInvestor2 = new ConcreteInvestor(new Investor("Investor 2"));
        EmailInvestor observerInvestor3 = new EmailInvestor(new Investor("Investor 3"),"Example012@gmail.com");
        subjectStock.Attach(observerInvestor1);
        subjectStock.Attach(observerInvestor2);
        subjectStock.Attach(observerInvestor3);
        subjectStock.Notify();

        subjectStock.setStockPrice(200);
        System.out.println("=====================================");
        ConcreteStock subjectStock2 = new ConcreteStock("Stock 2", 200);
        ObserverInvestor observerInvestor4 = new ConcreteInvestor(new Investor("Investor 3"));
        SMSInvestor observerInvestor5 = new SMSInvestor(new Investor("Investor 4"),"08123456789");
        subjectStock2.Attach(observerInvestor4);
        subjectStock2.Attach(observerInvestor5);
        subjectStock2.Attach(observerInvestor1);
        subjectStock2.Notify();

        subjectStock2.setStockPrice(300);
    }
}
