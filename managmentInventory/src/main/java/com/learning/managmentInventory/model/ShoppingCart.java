package com.learning.managmentInventory.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    private List<Product> productsToShop;
    private double totalToPay;

    public ShoppingCart() {
        this.productsToShop = new ArrayList<Product>();
        this.totalToPay = 0;
    }
    
    public void addProductToCart(Product productToAdd) {
        if (productsToShop == null) this.productsToShop = new ArrayList<Product>();
        productsToShop.add(productToAdd);
        totalToPay += productToAdd.getPriceProduct();
    }

    public void removeProductOfCart(Product product) {
        if (productsToShop == null) this.productsToShop = new ArrayList<Product>();
        else productsToShop = removeProduct(product, productsToShop);
    }

    private List<Product> removeProduct(Product product, List<Product> productsInCart) {
        if (productsInCart.isEmpty()) return productsToShop;
        else {
            if (productsInCart.getFirst().equals(product)) {
                productsInCart.removeFirst();
                totalToPay -= product.getPriceProduct();
                return productsInCart;
            } else {
                Product current = productsInCart.getFirst();
                productsInCart = removeProduct(product, productsInCart);

                productsInCart.addFirst(current);

                return productsInCart;
            }
        }
    }

    public int getQuantityProducts() {
        return productsToShop.size();
    }

    public double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }

    public List<Product> getProductsToShop() {
        return productsToShop;
    }

    public void setProductsToShop(List<Product> productsToShop) {
        this.productsToShop = productsToShop;
    }
    
}
