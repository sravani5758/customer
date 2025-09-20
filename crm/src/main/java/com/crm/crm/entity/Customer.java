package com.crm.crm.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CustomerType type; // MANUFACTURER, DISTRIBUTOR, RETAILER

    private String industry;
    private String geography;
    private String size; // SMALL, MEDIUM, LARGE

    @Embedded
    private ContactInfo contactInfo;

    private String gstNumber;
    private String address;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}


