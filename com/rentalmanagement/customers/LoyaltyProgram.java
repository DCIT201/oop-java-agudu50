package com.rentalmanagement.customers;

public interface LoyaltyProgram {
    void addRentalPoints(int points);
    int getLoyaltyPoints();
    String getLoyaltyStatus();


    public class Customer implements LoyaltyProgram {
        private String customerId;
        private String name;
        private int loyaltyPoints;

        public Customer(String customerId, String name) {
            this.customerId = customerId;
            this.name = name;
            this.loyaltyPoints = 0; // Default points
        }

        // Add loyalty points
        @Override
        public void addRentalPoints(int points) {
            this.loyaltyPoints += points;
        }

        // Get current loyalty points
        @Override
        public int getLoyaltyPoints() {
            return loyaltyPoints;
        }

        // Get loyalty status based on points
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






}
