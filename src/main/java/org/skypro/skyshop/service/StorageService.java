package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.*;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> productMap = new HashMap<>();
    private final Map<UUID, Article> articleMap = new HashMap<>();

    public StorageService() {
        initTestData();
    }

    private void initTestData() {
        Product p1 = new FixPriceProduct(UUID.randomUUID(), "Notebook", 100);
        Product p2 = new DiscountedProduct(UUID.randomUUID(), "Washing Machine", 300, 10);
        Product p3 = new SimpleProduct(UUID.randomUUID(), "Pen", 5);
        Article a1 = new Article(UUID.randomUUID(), "Java Book", "Learn Java");
        Article a2 = new Article(UUID.randomUUID(), "Spring Guide", "Spring Boot overview");

        productMap.put(p1.getId(), p1);
        productMap.put(p2.getId(), p2);
        productMap.put(p3.getId(), p3);

        articleMap.put(a1.getId(), a1);
        articleMap.put(a2.getId(), a2);
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public Collection<Article> getAllArticles() {
        return articleMap.values();
    }

    public Collection<Searchable> getAllSearchables() {
        List<Searchable> result = new ArrayList<>();
        result.addAll(productMap.values());
        result.addAll(articleMap.values());
        return result;
    }
}
