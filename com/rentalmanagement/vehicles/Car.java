package com.rentalmanagement.vehicles;

public class Car extends Vehicle {
    private boolean hasAirConditioning;


    public Car (String vehicleId, String model, double baseRentalRate, boolean hasAirConditioning ) {
        super(vehicleId, model, baseRentalRate);
        this.hasAirConditioning = hasAirConditioning;
    }



    @Override
    public double calculateRentalCost(int days){
        double cost = getBaseRentalRate() * days;

        if(hasAirConditioning){
            cost += 50; //Extra charge for AC
        }
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public String toString() {
        return super.toString() + ", hasAirConditioning: " + hasAirConditioning;
    }




}
