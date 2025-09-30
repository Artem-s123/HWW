package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class UserBasket {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }
}
