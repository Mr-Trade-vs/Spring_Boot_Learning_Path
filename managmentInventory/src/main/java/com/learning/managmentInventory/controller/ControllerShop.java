package com.learning.managmentInventory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.managmentInventory.model.Product;
import com.learning.managmentInventory.model.ShopService;

@Controller
@RequestMapping("/shop")
public class ControllerShop {

    private final ShopService shopCenter;

    public ControllerShop(ShopService shopCenter) {
        this.shopCenter = shopCenter;
    }

    @GetMapping("/products")
    public String displayAvaibleProducts(Model model) {
        List<Product> productsToShow = shopCenter.displayAllTheProducts();
        if (productsToShow == null || productsToShow.isEmpty()) return "no-info";
        else {
            model.addAttribute("productsToShow", productsToShow);
            return "shop-products"; 
        }
    }
    
}
