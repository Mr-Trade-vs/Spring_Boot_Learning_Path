package com.learning.managmentInventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learning.managmentInventory.model.Product;
import com.learning.managmentInventory.model.ProductService;

@Controller("/products")
public class ControllerProducts {
    
    private final ProductService productManagment;

    public ControllerProducts(ProductService productManagment) {
        this.productManagment = productManagment;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/save")
    public void saveDataProduct(Product product) {
        productManagment.addProduct(product);
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id, Model model) {
        Product product = productManagment.findProduct(id);
        model.addAttribute("product", product);
        return "product-info";
    }

}
