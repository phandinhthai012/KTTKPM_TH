package Bai02.Context;

import Bai02.Strategy.TaxStrategy;

public class Item {
    private String name;
    private double price;
    private TaxStrategy taxStrategy;

    public Item(TaxStrategy taxStrategy, double price, String name) {
        this.taxStrategy = taxStrategy;
        this.price = price;
        this.name = name;
    }
    public double calculateTax() {
        return taxStrategy.calculateTax(price);
    }
    public double getFinalPrice() {
        return price + calculateTax();
    }
    public String getTaxType() {
        return taxStrategy.getTaxType();
    }

    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Tax: " + calculateTax());
        System.out.println("Tax Type: " + getTaxType());
        System.out.println("Final Price: " + getFinalPrice());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaxStrategy getTaxStrategy() {
        return taxStrategy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
