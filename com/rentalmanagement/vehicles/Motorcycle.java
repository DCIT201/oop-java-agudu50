package com.rentalmanagement.vehicles;

public class Motorcycle extends Vehicle {
    private boolean hasHelmetIncluded;

    public Motorcycle (String vehicleId, String model, double baseRentalRate, boolean hasHelmetInclude) {
        super(vehicleId, model, baseRentalRate);
        this.hasHelmetIncluded = hasHelmetIncluded;
    }


    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasHelmetIncluded) {
            cost += cost;
        }

        return cost;
    }


    @Override
    public boolean isAvailableForRental() {
        return isAvailable();

    }

    @Override
    public String toString() {
        return super.toString() +", hasHelmetIncluded=" +hasHelmetIncluded;
    }








}
