package Bai03;

public class PaypalPayment implements Payment {
    private String email;
    private String password;

    public PaypalPayment() {
    }
    public PaypalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public double pay(double amount) {
        System.out.println("Paying " + amount + " using Paypal");
        return amount;
    }
}
