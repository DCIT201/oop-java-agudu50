package com.rentalmanagement.customers;

/**
 * The LoyaltyProgram interface defines methods for handling a customer's loyalty points.
 */
public interface LoyaltyProgram {

    /**
     * Adds rental points to the customer's total.
     * @param points The number of points to add.
     */
    void addRentalPoints(int points);

    /**
     * Retrieves the current loyalty points of the customer.
     * @return the current loyalty points.
     */
    int getLoyaltyPoints();

    /**
     * Determines the loyalty status of the customer based on their points.
     * @return the loyalty status ("Gold", "Silver", or "Bronze").
     */
    String getLoyaltyStatus();
}
