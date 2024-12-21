package com.rentalmanagement.customers;


/**
 * Represents a customer in the vehicle rental management system.
 * Stores the customer's ID, name, and loyalty points.
 */

public class Customer {
    private final String customerId;
    private final String name;
    private int loyaltyPoints;


    /**
     * Constructs a new Customer with the given ID and name.
     * Initially, the customer has 0 loyalty points.
     *
     * @param customerId The unique ID for the customer.
     * @param name       The name of the customer.
     */

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.loyaltyPoints = 0;
    }

    // Adding of getters
    public String getCustomerId() {
        return customerId;
    }


    /**
     * Adds rental points to the customer's loyalty points balance.
     *
     * @param points The number of points to add.
     */

    public void addRentalPoints(int points) {
        this.loyaltyPoints += points;
    }

    // Adding of getters
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }


    /**
     * Returns the loyalty status of the customer based on loyalty points.
     *
     * @return A string representing the customer's loyalty status.
     */
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
     * Provides a string representation of the customer.
     *
     * @return A formatted string containing the customer's details.
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
