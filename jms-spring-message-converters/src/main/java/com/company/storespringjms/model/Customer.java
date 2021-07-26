package com.company.storespringjms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Customer {
    private String customerId;
    private String fullName;

    public Customer(String customerId, String fullName) {
        this.customerId = customerId;
        this.fullName = fullName;
    }
}
