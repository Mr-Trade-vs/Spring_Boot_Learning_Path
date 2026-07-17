package com.learning.managmentInventory.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ShopService {
    
    private final ProductStore repositoryProducts;
    private ShoppingCart shoppingCart;

    public ShopService(ProductStore repositoryProducts, ShoppingCart shoppingCart) {
        this.repositoryProducts = repositoryProducts;
        this.shoppingCart = shoppingCart;
    }

    public List<Product> displayAllTheProducts() {
        List<Product> inventory = new ArrayList<Product>();
        inventory = repositoryProducts.findAll();

        if (inventory.isEmpty()) return null;
        else return inventory;

    }

    public void addToCart(String id) {
        Optional<Product> wasFound = repositoryProducts.findById(id);

        Product productToCart = wasFound.orElse(null);
        shoppingCart.addProductToCart(productToCart);
    }

    public int productsInCart() {
        return shoppingCart.getQuantityProducts();
    }
}
