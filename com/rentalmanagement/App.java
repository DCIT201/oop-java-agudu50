package com.rentalmanagement;

import com.rentalmanagement.Exceptions.InvalidVehicleIdException;
import com.rentalmanagement.Exceptions.VehicleNotAvailableException;
import com.rentalmanagement.customers.Customer;
import com.rentalmanagement.transactions.RentalAgency;
import com.rentalmanagement.vehicles.Car;
import com.rentalmanagement.vehicles.Motorcycle;
import com.rentalmanagement.vehicles.Truck;

public class App {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Add vehicles to the fleet
        agency.addVehicle(new Car("C1", "Sedan", 50, true, true));
        agency.addVehicle(new Motorcycle("M1", "Sport Bike", 30, true));
        agency.addVehicle(new Truck("T1", "Cargo Truck", 100, 500));

        // Display available vehicles
        System.out.println("Available Vehicles:");
        agency.getAvailableVehicles().forEach(System.out::println);

        // Create a customer
        Customer customer = new Customer("CU1", "John Doe");

        // Rent a vehicle with try-catch to handle exceptions
        try {
            System.out.println("\n" + agency.rentVehicle("C1", customer, 3)); // This will throw exceptions if needed
        } catch (InvalidVehicleIdException | VehicleNotAvailableException e) {
            System.out.println("Error during rental: " + e.getMessage());
        }

        // Display available vehicles after renting
        System.out.println("\nAvailable Vehicles After Renting:");
        agency.getAvailableVehicles().forEach(System.out::println);

        // Generate rental report
        System.out.println("\nRental Report:");
        agency.generateRentalReport();

        // Return the vehicle with try-catch to handle exceptions
        String returnResult = agency.returnVehicle("C1");
        System.out.println("\nReturn Result: " + returnResult);

        // Display available vehicles after return
        System.out.println("\nAvailable Vehicles After Return:");
        agency.getAvailableVehicles().forEach(System.out::println);
    }
}
