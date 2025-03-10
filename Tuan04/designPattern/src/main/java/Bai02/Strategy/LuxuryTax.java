package Bai02.Strategy;

public class LuxuryTax implements TaxStrategy{
    @Override
    public double calculateTax(double price) {
        return price * 0.2;
    }

    @Override
    public String getTaxType() {
        return "Luxury Tax";
    }
}
