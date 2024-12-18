package com.rentalmanagement.vehicles;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
// private fields (Encapsulation)
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    private double ratings;


//Creating  Constructors Vehicle
    public Vehicle (String vehicleId, String model, double baseRentalRate){
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true; // Default: available for rental
        this.ratings = ratings;
    }



    //Add a rating(1-5)
    public void addRating(double rating){
        if(rating >=0 || rating <= 5){
            this.ratings += rating;

        }else {
            throw new IllegalArgumentException("Ratings must be between 0 and 5");
        }



    }

    //Get average rating
    public double getAverageRating(){
        return ratings;

    }




    //Abstract methods (Abstraction)
    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();


    //Getters and Setters
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        this.baseRentalRate = baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
