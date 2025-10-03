
package org.skypro.skyshop.model.basket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductBasket {
    private final Map<UUID, Integer> items = new HashMap<>();

    // Добавить единицу товара в корзину (увеличить счётчик по ключу id)
    public void addProduct(UUID id) {
        items.merge(id, 1, Integer::sum);
    }

    // Получить неизменяемую Map (id → количество)
    public Map<UUID, Integer> getProducts() {
        return Collections.unmodifiableMap(items);
    }
}
