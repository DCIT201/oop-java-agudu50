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
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                if (!vehicle.isAvailableForRental()) {
                    throw new VehicleNotAvailableException("Vehicle is currently unavailable for rental!");
                }
                double rentalCost = vehicle.calculateRentalCost(days);
                vehicle.setAvailable(false); // Marking vehicle as rented
                RentalTransaction transaction = new RentalTransaction(vehicle, customer, days, rentalCost);
                rentalTransactions.add(transaction);
                customer.addRentalPoints(days);
                return String.format("Rental successful! Cost: $%.2f. Loyal Points: %d", rentalCost, customer.getLoyaltyPoints());
            }
        }
        throw new InvalidVehicleIdException("Vehicle ID not found!");
    }

    // Returning a vehicle
    public String returnVehicle(String vehicleId) {
        RentalTransaction transactionToRemove = null;
        for (RentalTransaction transaction : rentalTransactions) {
            if (transaction != null && transaction.getVehicle() != null &&
                    transaction.getVehicle().getVehicleId().equals(vehicleId)) {
                transaction.getVehicle().setAvailable(true);
                transactionToRemove = transaction;
                break;
            }
        }
        if (transactionToRemove != null) {
            rentalTransactions.remove(transactionToRemove);
            return "Vehicle returned successfully!";
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
