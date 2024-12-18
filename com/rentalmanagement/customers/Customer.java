package com.rentalmanagement.customers;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private int loyaltyPoints;
    private List<String> rentalsHistory; // Keeps track of rented vehicle IDs

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.loyaltyPoints = 0;
        this.rentalsHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Add loyalty points
    public void addLoyaltyPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative.");
        }
        this.loyaltyPoints += points; // Correctly updating loyaltyPoints field
    }

    // Get current loyalty points
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Get loyalty status based on points
    public String getLoyaltyStatus() {
        if (loyaltyPoints >= 100) {
            return "Gold";
        } else if (loyaltyPoints >= 50) {
            return "Silver";
        } else {
            return "Bronze";
        }
    }

    // Add to rental history
    public void addToRentalHistory(String vehicleId) {
        rentalsHistory.add(vehicleId);
    }

    // Get rental history
    public List<String> getRentalHistory() {
        return rentalsHistory;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                ", loyaltyStatus='" + getLoyaltyStatus() + '\'' +
                '}';
    }
}
