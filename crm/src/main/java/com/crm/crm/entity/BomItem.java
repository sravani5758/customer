package com.crm.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "bom_items")
public class BomItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String materialName;
    private String materialSku;
    private Integer quantityRequired;
    private String unitOfMeasure;

    // Getters and setters
}