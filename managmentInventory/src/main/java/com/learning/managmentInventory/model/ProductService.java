package com.learning.managmentInventory.model;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    private final ProductStore repositoryProdcuts;

    public ProductService(ProductStore repositoryProdcuts) {
        this.repositoryProdcuts = repositoryProdcuts;
    }

    public void addProduct(Product product) {
        product = idGeneration(product);
        repositoryProdcuts.save(product);
    }

    public Product findProduct(String id) {
        Optional<Product> wasFound = repositoryProdcuts.findById(id);

        //We aren't sure if the sql query get us the value, could be empty that's why if product isn't found we return null.
        Product product = wasFound.orElse(null);

        return product;
    }

    private Product idGeneration(Product product) {
        Optional<Product> lastProduct = repositoryProdcuts.findTopByOrderByIdDesc();

        if (lastProduct.isEmpty()) {
                product.setId("A0000000001");
                return product;
        }

        String idProduct = lastProduct.get().getId();

        int updateNumber = Integer.parseInt(idProduct.substring(1));
        updateNumber++;

        product.setId(String.format("A%09d", updateNumber)); 
        return product;
    }
}
