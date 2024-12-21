package com.rentalmanagement.vehicles;

public class Car extends Vehicle {
    private final boolean isAutomatic;

    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable, boolean automatic) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.isAutomatic = automatic;
    }
public boolean isAutomatic() {
        return isAutomatic;
}

    @Override
    public boolean isAvailableForRental() {
        return super.isAvailable();
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;
    }
    @Override
    public String toString() {
        return "Car{" +
                "vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                ", isAutomatic=" + isAutomatic +
                '}';
    }

}
