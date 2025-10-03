package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    // Добавляет товар в корзину по его UUID
    public void addProduct(UUID id) {
        // Проверим, что товар существует (если нет — выкинет NoSuchProductException)
        storageService.getProductById(id);
        productBasket.addProduct(id);
    }

    // Формирует UserBasket из текущего состояния ProductBasket
    public UserBasket getUserBasket() {
        var map = productBasket.getProducts();
        List<BasketItem> items = map.entrySet().stream()
                .map(e -> new BasketItem(storageService.getProductById(e.getKey()), e.getValue()))
                .collect(Collectors.toList());
        return new UserBasket(items);
    }
}
