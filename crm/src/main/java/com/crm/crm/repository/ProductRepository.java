package com.crm.crm.repository;

import com.crm.crm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStockQuantityLessThan(int quantity);
    Product findBySku(String sku);
}
