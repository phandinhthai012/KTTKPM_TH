package compositePattern;

public class SingleProduct implements Product{
    private double price;
    private String name;

    public SingleProduct(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void show() {
        System.out.println("Product: " + this.name + ", Price: " + this.price +"VND");
    }
}
