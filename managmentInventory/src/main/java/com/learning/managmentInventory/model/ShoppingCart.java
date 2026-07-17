package com.learning.managmentInventory.model;

import java.util.Stack;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    private Stack<Product> productsToShop;
    private int quantityProducts;

    public ShoppingCart() {
        this.productsToShop = new Stack<Product>();
        this.quantityProducts = 0;
    }
    
    public void addProductToCart(Product productToAdd) {
        if (productsToShop == null) this.productsToShop = new Stack<Product>();
        productsToShop.push(productToAdd);
        quantityProducts++;
    }

    public void removeProductOfCart(Product product) {
        if (productsToShop == null) this.productsToShop = new Stack<Product>();
        else productsToShop = removeProduct(product, productsToShop);
    }

    private Stack<Product> removeProduct(Product product, Stack<Product> productsInCart) {
        if (productsInCart.isEmpty()) return productsToShop;
        else {
            if (productsInCart.peek().equals(product)) {
                productsInCart.pop();
                quantityProducts--;
                return productsInCart;
            } else {
                Product current = productsInCart.pop();
                productsInCart = removeProduct(product, productsInCart);

                productsInCart.push(current);

                return productsInCart;
            }
        }
    }

    public int getQuantityProducts() {
        return quantityProducts;
    }

    public void setQuantityProducts(int quantityProducts) {
        this.quantityProducts = quantityProducts;
    }
    
}
