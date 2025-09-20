package com.crm.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role; // ADMIN, SALES_MANAGER, INVENTORY_MANAGER, DISTRIBUTOR
    private boolean accountLocked;
    private String resetToken;
    private LocalDateTime tokenExpiry;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
