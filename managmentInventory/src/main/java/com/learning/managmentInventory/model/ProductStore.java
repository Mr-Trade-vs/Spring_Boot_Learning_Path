package com.learning.managmentInventory.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStore extends JpaRepository<Product, String> {
    //This allow make a query O(1) and made easier the work to define a new ID for a product.
    Optional<Product> findTopByOrderByIdDesc();
    
}
