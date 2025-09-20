package com.crm.crm.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ContactInfo {
    private String primaryContact;
    private String phone;
    private String email;
    private String secondaryContact;
    private String secondaryPhone;

    // Getters and setters
}