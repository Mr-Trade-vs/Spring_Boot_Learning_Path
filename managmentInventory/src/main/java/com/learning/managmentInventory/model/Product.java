package com.learning.managmentInventory.model;

import com.learning.managmentInventory.exceptions.NotEmptyFields;

import jakarta.annotation.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private String id;

    @Nonnull
    private String nameProduct;

    @Nonnull
    private int stockProduct;

    @Nonnull
    private double priceProduct;

    

    public Product() {
    }

    public Product(String id, String nameProduct, int stockProduct, double priceProduct) {
        try {
            if (id.isEmpty() || nameProduct.isEmpty()) {
                throw new NotEmptyFields("One of the fields are empty.");
            }
            this.id = id;
            this.nameProduct = nameProduct;
            this.stockProduct = stockProduct;
            this.priceProduct = priceProduct;
        } catch (NotEmptyFields e) {
            // TODO: handle exception
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(int stockProduct) {
        this.stockProduct = stockProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

}
