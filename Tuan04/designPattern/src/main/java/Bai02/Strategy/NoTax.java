package Bai02.Strategy;

public class NoTax implements TaxStrategy{
    @Override
    public double calculateTax(double price) {
        return 0;
    }

    @Override
    public String getTaxType() {
        return "No Tax";
    }
}
