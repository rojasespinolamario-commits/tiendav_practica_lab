package model;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public List<Product> getProducts() {
        return products;
    }
}
