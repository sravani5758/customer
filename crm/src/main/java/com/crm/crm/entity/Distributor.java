package com.crm.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "distributors")
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private ContactInfo contactInfo;

    private String region;
    private String assignedTerritory;

    @ManyToMany
    @JoinTable(
            name = "distributor_products",
            joinColumns = @JoinColumn(name = "distributor_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> assignedProducts;

    // Performance metrics
    private BigDecimal totalSales;
    private Integer totalOrders;
    private BigDecimal performanceRating;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}