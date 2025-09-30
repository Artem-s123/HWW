package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BasketService {

    private final StorageService storageService;
    private final UserBasket userBasket;

    public BasketService(StorageService storageService) {
        this.storageService = storageService;
        this.userBasket = new UserBasket();
    }

    // Добавление продукта в корзину
    public void addProduct(UUID id) {
        Product product = storageService.getProductById(id); // если не найдёт — выбросит NoSuchProductException
        userBasket.getProducts().add(product);
    }

    // Получение содержимого корзины
    public UserBasket getUserBasket() {
        return userBasket;
    }
}
