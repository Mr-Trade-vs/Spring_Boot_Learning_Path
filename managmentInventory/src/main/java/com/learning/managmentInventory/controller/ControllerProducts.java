package com.learning.managmentInventory.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.managmentInventory.exceptions.NotEmptyFields;
import com.learning.managmentInventory.model.Product;
import com.learning.managmentInventory.model.ProductStore;

@RequestMapping("/products")
@Service
public class ControllerProducts {
    
    private ProductStore repositoryProducts;

    public ControllerProducts(ProductStore repositoryProducts) {
        this.repositoryProducts = repositoryProducts;
    }

    @PostMapping("/addProduct")
    public String addProduct (String id, String name, int stock, double price) {
        try {
            if ((!id.isEmpty() && id != null) && (!name.isEmpty() && name != null) && stock >= 0 && price >= 0) {
                Product product = new Product(id, name, stock, price);
                repositoryProducts.save(product);
                return "Product succesfull added";
            } else throw new NotEmptyFields("Be sure you fill all the camps, empty fields aren't allowed");
        } catch (NotEmptyFields e) {
            String explain = "One or more fields are empty, be sure all the fields are fill to save the product";
            return explain;
        }
    }

}
