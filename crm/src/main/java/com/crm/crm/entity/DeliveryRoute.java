package com.crm.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "delivery_routes")
public class DeliveryRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeName;
    private String region;

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private Distributor assignedDistributor;

    @ElementCollection
    private List<String> deliveryPoints;

    private BigDecimal totalDistance;
    private Integer estimatedDeliveryTime; // in minutes

    // Schedule
    private LocalTime startTime;
    private LocalTime endTime;
    private DayOfWeek deliveryDay;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}