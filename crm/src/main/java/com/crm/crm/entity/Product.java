package com.crm.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;

    private String category;
    private String description;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    private String unitOfMeasure;
    private Integer stockQuantity;
    private Integer reorderLevel;

    // For BOM (Bill of Materials)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<BomItem> bomItems;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}

