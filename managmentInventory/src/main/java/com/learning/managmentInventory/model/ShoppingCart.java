package com.learning.managmentInventory.model;

import java.util.Stack;

public class ShoppingCart {

    private Stack<Product> productsToShop;

    public ShoppingCart() {
        this.productsToShop = new Stack<Product>();
    }
    
    public void addProductToCart(Product productToAdd) {
        if (productsToShop == null) this.productsToShop = new Stack<Product>();
        else productsToShop.push(productToAdd);
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
                return productsInCart;
            } else {
                Product current = productsInCart.pop();
                productsInCart = removeProduct(product, productsInCart);

                productsInCart.push(current);

                return productsInCart;
            }
        }
    }
        

    
}
