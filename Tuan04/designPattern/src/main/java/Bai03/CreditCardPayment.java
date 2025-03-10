package Bai03;

public class CreditCardPayment implements Payment {
    private String cardNumber;
    private String cardType;
    private String cardExpDate;
    private String cardCVV;

    public CreditCardPayment() {
    }

    public CreditCardPayment(String cardNumber, String cardType, String cardExpDate, String cardCVV) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardExpDate = cardExpDate;
        this.cardCVV = cardCVV;
    }

    @Override
    public double pay(double amount) {
        System.out.println("Paying " + amount + " using credit card");
        return amount;
    }
}
