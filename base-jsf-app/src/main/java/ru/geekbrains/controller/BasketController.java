package ru.geekbrains.controller;

import ru.geekbrains.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SessionScoped
@Named
public class BasketController implements Serializable {

    private Map<Product, Integer> basketProducts;

    public BasketController() {
        basketProducts = new HashMap<>();
    }

    public void addProductToBasket(Product product) {
        basketProducts.put(product, basketProducts.getOrDefault(product, 0) + 1);
    }

    public Set<Map.Entry<Product, Integer>> getBasketProducts() {
        return basketProducts.entrySet();
    }

    public void deleteProduct(Product product) {
        int value;
        if ((value = basketProducts.get(product)) == 1){
            basketProducts.remove(product);
        } else {
            basketProducts.put(product, value - 1);
        }

    }
}
