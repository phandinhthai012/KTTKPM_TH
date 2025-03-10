package Bai03;

public class ProcessingFeeDecorator extends PaymentDecorator{
    public ProcessingFeeDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public double pay(double amount) {
        double fee = amount * 0.05; // Phí xử lý 5%
        System.out.println("Áp dụng phí xử lý: " + fee + " VND");
        return super.pay(amount + fee);
    }
}
