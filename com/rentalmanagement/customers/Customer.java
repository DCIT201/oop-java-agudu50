package com.rentalmanagement.customers;

/**
 * The Customer class represents a customer in the rental management system.
 * It implements the LoyaltyProgram interface to manage loyalty points.
 */
public class Customer implements LoyaltyProgram {
    private final String customerId;
    private final String name;
    private int loyaltyPoints;

    /**
     * Constructs a new customer with an ID and name.
     * Loyalty points are initially set to 0.
     * @param customerId the unique identifier for the customer.
     * @param name the name of the customer.
     */
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.loyaltyPoints = 0; // Default points
    }

    /**
     * Adds rental points to the customer's total.
     * @param points the points to add.
     */
    @Override
    public void addRentalPoints(int points) {
        if (points >= 0) {
            this.loyaltyPoints += points;
        } else {
            throw new IllegalArgumentException("Points cannot be negative.");
        }
    }

    /**
     * Retrieves the current loyalty points of the customer.
     * @return the current loyalty points.
     */
    @Override
    public int getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    /**
     * Returns the customer's loyalty status based on their points.
     * @return the loyalty status ("Gold", "Silver", or "Bronze").
     */
    @Override
    public String getLoyaltyStatus() {
        if (loyaltyPoints >= 100) {
            return "Gold";
        } else if (loyaltyPoints >= 50) {
            return "Silver";
        } else {
            return "Bronze";
        }
    }

    /**
     * Returns a string representation of the Customer object.
     * @return a string representing the customer.
     */
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
