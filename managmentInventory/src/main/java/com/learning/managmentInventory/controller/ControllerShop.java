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
        if (productsToShow.isEmpty() || productsToShow == null) return "no-info";
        else {
            for (Product product : productsToShow) {
                model.addAttribute(product.getId(), product);
            }
            return "shop-products";
        }
    }
    
}
