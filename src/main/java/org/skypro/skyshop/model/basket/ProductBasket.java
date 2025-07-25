// src/main/java/org/skypro/skyshop/model/basket/ProductBasket.java
package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@SessionScope
public class ProductBasket {

    private final Map<UUID, Integer> items = new HashMap<>();

    /**
     * Добавить единицу товара в корзину (увеличить счётчик по ключу id)
     */
    public void addProduct(UUID id) {
        items.merge(id, 1, Integer::sum);
    }

    /**
     * Получить неизменяемый view на корзину
     */
    public Map<UUID, Integer> getProducts() {
        return Collections.unmodifiableMap(items);
    }
}
