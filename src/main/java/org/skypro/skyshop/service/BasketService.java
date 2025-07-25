// src/main/java/org/skypro/skyshop/service/BasketService.java
package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.BasketItem;
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

    /**
     * Добавляет товар в корзину по его UUID.
     * @throws IllegalArgumentException, если товара с таким id нет в StorageService
     */
    public void addProduct(UUID id) {
        storageService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Товар с id=" + id + " не найден"))
        ;
        productBasket.addProduct(id);
    }

    /**
     * Формирует UserBasket из текущего состояния ProductBasket
     */
    public UserBasket getUserBasket() {
        // Берём мапу id→count
        var map = productBasket.getProducts();
        // Преобразуем в список BasketItem
        List<BasketItem> items = map.entrySet().stream()
                .map(e -> {
                    var product = storageService.getProductById(e.getKey()).get();
                    return new BasketItem(product, e.getValue());
                })
                .collect(Collectors.toList());
        // Возвращаем готовый UserBasket (внутри считает total)
        return new UserBasket(items);
    }
}
