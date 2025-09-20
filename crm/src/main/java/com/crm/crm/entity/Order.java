package com.crm.crm.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime orderDate;
    private LocalDateTime expectedDeliveryDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED

    private BigDecimal totalAmount;
    private String notes;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    // For backorders
    private Boolean isBackorder;
    private LocalDateTime backorderFulfillmentDate;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}

