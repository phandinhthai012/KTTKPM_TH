package compositePattern;

import java.util.ArrayList;
import java.util.List;

public class ProductGroup implements Product{
    private String name;
    private List<Product> products = new ArrayList<>();

    public ProductGroup(String name) {
        this.name = name;
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public void removeProduct(Product product){
        this.products.remove(product);
    }
    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String getName() {
        return "Group: " + this.name;
    }

    @Override
    public void show() {
        System.out.println("Group: " + this.name);
        for (Product product : products) {
            product.show();
        }
        System.out.println("Total price: " + this.getPrice() + "VND");
    }
}
