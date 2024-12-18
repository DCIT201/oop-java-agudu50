package com.rentalmanagement.vehicles;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.loadCapacity = loadCapacity;

    }


@Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (loadCapacity * 10);// charged on load
}


@Override
    public boolean isAvailableForRental(){
        return isAvailable();
    }

    @Override
    public String toString() {
        return super.toString() + ", loadCapacity" + loadCapacity;

    }


}
