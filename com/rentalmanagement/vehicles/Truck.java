package com.rentalmanagement.vehicles;

public class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, double cargoCapacity) {
        super(vehicleId, model, baseRentalRate, true);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (cargoCapacity * 0.1); // Additional cost based on cargo capacity
    }

    @Override
    public boolean isAvailableForRental() {
        return false;
    }
}
