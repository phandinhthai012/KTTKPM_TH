package Bai03;

public class Main {
    public static void main(String[] args) {
        double amount = 1000000; //
        // Thanh toán bằng thẻ tín dụng với phí xử lý
        Payment creditCardPayment = new ProcessingFeeDecorator(new CreditCardPayment());
        System.out.println("Số tiền cuối cùng: " + creditCardPayment.pay(amount) + " VND\n");

        // Thanh toán bằng PayPal với mã giảm giá
        Payment paypalWithDiscount = new DiscountDecorator(new PaypalPayment());
        System.out.println("Số tiền cuối cùng: " + paypalWithDiscount.pay(amount) + " VND\n");

        // Thanh toán bằng thẻ tín dụng với cả phí xử lý và mã giảm giá
        Payment complexPayment = new DiscountDecorator(
                new ProcessingFeeDecorator(new CreditCardPayment()));
        System.out.println("Số tiền cuối cùng: " + complexPayment.pay(amount) + " VND");
    }
}
