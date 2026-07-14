package com.learning.managmentInventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.managmentInventory.model.Product;
import com.learning.managmentInventory.model.ProductService;

@Controller
@RequestMapping("/products")
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
    public String saveDataProduct(Product product) {
        Product savedProduct =  productManagment.addProduct(product);
        return "redirect:/products/" + savedProduct.getId();
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id, Model model) {
        Product product = productManagment.findProduct(id);
        model.addAttribute("product", product);
        return "product-info";
    }

    @GetMapping("/search")
    public String searchTemplate() {
        return "found-product";
    }
    
    @GetMapping("/searchProduct")
    public String searchProduct(@RequestParam String id){
        return "redirect:/products/" + id;
    }

    @DeleteMapping("/remove/{id}")
    public String deleteProduct(@PathVariable String id) {
        System.out.println(id);
        productManagment.deleteProduct(id);
        System.out.println("Id enviado a eliminar");
        return "redirect:/products/form";
    }

}
