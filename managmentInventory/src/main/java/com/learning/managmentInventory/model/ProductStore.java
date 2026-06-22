package com.learning.managmentInventory.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStore extends JpaRepository<Product, String> {
    
}
