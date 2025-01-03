package com.rentalmanagement.vehicles;

public class Motorcycle extends Vehicle {

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 0.8;  // Discounted rate for motorcycles
    }

    @Override
    public boolean isAvailableForRental() {
        return super.isAvailable();  // Delegate to the superclass method
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                ", isAvailable=" + isAvailable() +
                '}';
    }
}
