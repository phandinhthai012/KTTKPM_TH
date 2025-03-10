package Bai02.Strategy;

public class VatTax implements TaxStrategy{
    @Override
    public double calculateTax(double price) {
        return price * 0.1;
    }

    @Override
    public String getTaxType() {
        return "VAT";
    }
}
