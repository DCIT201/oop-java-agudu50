package com.rentalmanagement.vehicles;

public class Motorcycle extends Vehicle {
    private final boolean hasHelmetIncluded;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean hasHelmetIncluded) {
        super(vehicleId, model, baseRentalRate);
        this.hasHelmetIncluded = hasHelmetIncluded; // Correct assignment
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasHelmetIncluded) {
            cost += 20; // Add extra cost for the helmet
        }
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Ensure `isAvailable` is implemented in Vehicle
    }

    @Override
    public String toString() {
        return super.toString() + ", hasHelmetIncluded=" + hasHelmetIncluded;
    }
}
