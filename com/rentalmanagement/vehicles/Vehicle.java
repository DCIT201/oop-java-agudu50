package com.rentalmanagement.vehicles;

public abstract class Vehicle {
    private final String vehicleId;
    private final String model;
    private final double baseRentalRate;
    private boolean isAvailable;  // Private field to store the availability status

    // Constructor to initialize the vehicle properties
    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;  // Initialize availability
    }

    // Getters and setters for the fields
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;  // Return the availability status
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;  // Set the availability status
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                '}';
    }

    // Abstract method to be implemented by subclasses (like Car)
    public abstract double calculateRentalCost(int days);

    // Abstract method to be implemented by subclasses for checking availability
    public abstract boolean isAvailableForRental();
}
