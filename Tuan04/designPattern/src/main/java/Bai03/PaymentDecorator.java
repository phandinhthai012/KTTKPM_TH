package Bai03;

public class PaymentDecorator implements Payment {
    protected Payment payment;

    public PaymentDecorator(Payment payment) {
        this.payment = payment;
    }

    @Override
    public double pay(double amount) {
        return payment.pay(amount);
    }
}
