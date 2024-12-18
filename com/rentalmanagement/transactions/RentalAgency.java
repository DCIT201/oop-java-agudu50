package com.rentalmanagement.transactions;

import com.rentalmanagement.customers.Customer;
import com.rentalmanagement.vehicles.Vehicle;
import com.rentalmanagement.Exceptions.InvalidVehicleIdException;
import com.rentalmanagement.Exceptions.VehicleNotAvailableException;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> vehicleFleet; // Composition
    private List<RentalTransaction> rentalTransactions;


    public RentalAgency() {
        this.vehicleFleet = new ArrayList<>();
        this.rentalTransactions = new ArrayList<>();
    }
// Adding a vehicle to the fleet
    public void addVehicle(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
    }


//Display available vehicles
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.isAvailableForRental()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    //Renting a vehicle
    public String rentVehicle(String vehicleId, Customer customer, int days) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailableForRental()) {
             double rentalCost = vehicle.calculateRentalCost(days);
             vehicle.setAvailable(false);// Marking vehicle as rented
                RentalTransaction transaction = new RentalTransaction(vehicle, customer, days, rentalCost);
                rentalTransactions.add(transaction);

                customer.addLoyaltyPoints(days);
                return "Rental successful! Cost: $" + rentalCost + " .Loyal Points: " + customer.getLoyaltyPoints();

            }
        }
        return "Vehiccle ID is not found in current rentals!";
    }

    public String returnVehicle(String vehicleId, double rating) {
        for (RentalTransaction transaction : rentalTransactions) {
            if (transaction.getVehicle().getVehicleId().equals(vehicleId)) {
                transaction.getVehicle().setAvailable(true);
                transaction.getVehicle().addRating(rating); // Add rating
                rentalTransactions.remove(transaction);
                return "Vehicle returned successfully! Thank you for rating: " + rating;
            }
        }
        return "Vehicle ID not found in current rentals!";
    }




    //Generate a report of all rentals
    public void generateRentalReport(){
        if (rentalTransactions.isEmpty()){
            System.out.println("No rentals found!");
            return;
        }

        System.out.println("Rental Transactions:");
        for (RentalTransaction transaction : rentalTransactions) {
            System.out.println(transaction);
        }
    }


}
