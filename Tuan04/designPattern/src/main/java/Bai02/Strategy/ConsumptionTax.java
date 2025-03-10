package Bai02.Strategy;

public class ConsumptionTax implements TaxStrategy{
    @Override
    public double calculateTax(double price) {
        return price * 0.05;
    }

    @Override
    public String getTaxType() {
        return "Consumption Tax";
    }
}
