package Bai03;

public class DiscountDecorator extends PaymentDecorator {
    public DiscountDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public double pay(double amount) {
        double discount = amount * 0.1; // Giảm giá 10%
        System.out.println("Áp dụng giảm giá: " + discount + " VND");
        return super.pay(amount - discount);
    }
}
