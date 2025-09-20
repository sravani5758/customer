package com.crm.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String location;
    private Integer capacity;
    private Integer currentUtilization;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<WarehouseInventory> inventory;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}

