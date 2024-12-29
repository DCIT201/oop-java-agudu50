package com.rentalmanagement.transactions;

import com.rentalmanagement.Exceptions.InvalidVehicleIdException;
import com.rentalmanagement.Exceptions.VehicleNotAvailableException;
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
    public String rentVehicle(String vehicleId, Customer customer, int days)
            throws InvalidVehicleIdException, VehicleNotAvailableException {
        // Check if the vehicle ID is valid (non-null and non-empty)
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new InvalidVehicleIdException("Vehicle ID is invalid.");
        }

        // Attempt to find the vehicle in the fleet by its ID
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle == null) {
            throw new InvalidVehicleIdException("Vehicle with ID " + vehicleId + " not found.");
        }

        // Check if the vehicle is available for rental
        if (!vehicle.isAvailableForRental()) {
            throw new VehicleNotAvailableException("Vehicle with ID " + vehicleId + " is currently unavailable for rental.");
        }

        // Calculate rental cost and proceed with renting
        double rentalCost = vehicle.calculateRentalCost(days);
        vehicle.setAvailable(false); // Marking the vehicle as rented
        RentalTransaction transaction = new RentalTransaction(vehicle, customer, days, rentalCost);
        rentalTransactions.add(transaction);
        customer.addRentalPoints(days);

        return String.format("Rental successful! Cost: $%.2f. Loyalty Points: %d", rentalCost, customer.getLoyaltyPoints());
    }

    // Helper method to find a vehicle by its ID
    private Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null; // Vehicle not found
    }

    // Returning a vehicle
    public String returnVehicle(String vehicleId) {
        RentalTransaction transactionToRemove = null;
        // Look for the transaction involving the vehicle
        for (RentalTransaction transaction : rentalTransactions) {
            if (transaction != null && transaction.getVehicle() != null &&
                    transaction.getVehicle().getVehicleId().equals(vehicleId)) {
                transaction.getVehicle().setAvailable(true); // Mark vehicle as available again
                transactionToRemove = transaction;
                break;
            }
        }

        // Remove the transaction if it was found
        if (transactionToRemove != null) {
            rentalTransactions.remove(transactionToRemove);
            return "Vehicle returned successfully!";
        } else {
            return "Vehicle ID not found in current rentals!";
        }
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
