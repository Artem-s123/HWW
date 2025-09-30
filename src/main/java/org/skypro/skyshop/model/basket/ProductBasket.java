package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getTotalPrice() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}
