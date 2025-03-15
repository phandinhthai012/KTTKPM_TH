package compositePattern;

public class MainTest {
    public static void main(String[] args) {
        // tạo composite để thể hiện cấu trúc cây của sản phẩm
        ProductGroup group1 = new ProductGroup("Group 1");
        ProductGroup group2 = new ProductGroup("Group 2");
        ProductGroup group3 = new ProductGroup("Group 3");

        // tạo leaf là sản phẩm đơn lẻ để thêm vào composite
        Product product1 = new SingleProduct(1000, "Product 1");
        Product product2 = new SingleProduct(2000, "Product 2");
        Product product3 = new SingleProduct(3000, "Product 3");
        Product product4 = new SingleProduct(4000, "Product 4");
        Product product5 = new SingleProduct(5000, "Product 5");
        // thêm sản phẩm vào composite
        group1.addProduct(product1);
        group1.addProduct(product2);
        group2.addProduct(product3);
        group2.addProduct(product4);
        group3.addProduct(product5);
        // thể hiện cấu trúc cây của sản phẩm
        group1.show();
        group2.show();
        group3.show();
    }
}
