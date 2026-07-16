package com.learning.managmentInventory.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ShopService {
    
    private final ProductStore repositoryProducts;

    public ShopService(ProductStore repositoryProducts) {
        this.repositoryProducts = repositoryProducts;
    }

    public List<Product> displayAllTheProducts() {
        List<Product> inventory = new ArrayList<Product>();
        inventory = repositoryProducts.findAll();

        if (inventory.isEmpty()) return null;
        else return inventory;

    }
}
