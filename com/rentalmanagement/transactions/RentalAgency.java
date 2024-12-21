package com.rentalmanagement.transactions;

import com.rentalmanagement.customers.Customer;
import com.rentalmanagement.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalAgency {
    private final List<Vehicle> vehicleFleet; // Composition
    private final List<RentalTransaction> rentalTransactions;

    public RentalAgency() {
        this.vehicleFleet = new ArrayList<>();
        this.rentalTransactions = new ArrayList<>();
    }

    // Adding a vehicle to the fleet
    public void addVehicle(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
    }

    // Display available vehicles
    public List<Vehicle> getAvailableVehicles() {
        return vehicleFleet.stream()
                .filter(Vehicle::isAvailableForRental)
                .collect(Collectors.toList());
    }

    // Renting a vehicle
    public String rentVehicle(String vehicleId, Customer customer, int days) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailableForRental()) {
                double rentalCost = vehicle.calculateRentalCost(days);
                vehicle.setAvailable(false); // Marking vehicle as rented
                RentalTransaction transaction = new RentalTransaction(vehicle, customer, days, rentalCost);
                rentalTransactions.add(transaction);
                customer.addRentalPoints(days);
                return "Rental successful! Cost: $" + rentalCost + " .Loyal Points: " + customer.getLoyaltyPoints();
            }
        }
        return "Vehicle ID not found or unavailable!";
    }

    // Returning a vehicle
    public String returnVehicle(String vehicleId) {
        for (RentalTransaction transaction : rentalTransactions) {
            if (transaction.getVehicle().getVehicleId().equals(vehicleId)) {
                transaction.getVehicle().setAvailable(true);
                rentalTransactions.remove(transaction);
                return "Vehicle returned successfully!";
            }
        }
        return "Vehicle ID not found in current rentals!";
    }

    // Generate a report of all rentals
    public void generateRentalReport() {
        if (rentalTransactions.isEmpty()) {
            System.out.println("No rental transactions found!");
        } else {
            System.out.println("Rental Transactions:");
            rentalTransactions.forEach(System.out::println);
        }
    }
}
