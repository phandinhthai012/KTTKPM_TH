package Bai02.Strategy;

public interface TaxStrategy {
    double calculateTax(double price);
    String getTaxType();
}
