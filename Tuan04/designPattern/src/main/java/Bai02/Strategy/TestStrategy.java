package Bai02.Strategy;

import Bai02.Context.Item;

public class TestStrategy {
    public static void main(String[] args) {
//        double price = 100;
//        TaxStrategy taxStrategy = new ConsumptionTax();
//        System.out.println("Price: " + price + " - Tax Type: " + taxStrategy.getTaxType() + " - Tax: " + taxStrategy.calculateTax(price));
//
//        taxStrategy = new VatTax();
//        System.out.println("Price: " + price + " - Tax Type: " + taxStrategy.getTaxType() + " - Tax: " + taxStrategy.calculateTax(price));
//
//        taxStrategy = new NoTax();
//        System.out.println("Price: " + price + " - Tax Type: " + taxStrategy.getTaxType() + " - Tax: " + taxStrategy.calculateTax(price));
        Item item1 = new Item(new ConsumptionTax(), 100, "Item 1");
        item1.display();
        System.out.println("=====================================");
        Item item2 = new Item(new VatTax(), 100, "Item 2");
        item2.display();
        System.out.println("=====================================");
        Item item3 = new Item(new NoTax(), 100, "Item 3");
        item3.display();
        System.out.println("=====================================");
        Item item4 = new Item(new ConsumptionTax(), 200, "Item 4");
        item4.display();
        System.out.println("=====================================");

    }
}
