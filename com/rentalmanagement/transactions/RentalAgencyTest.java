package com.rentalmanagement.transactions;

import com.rentalmanagement.Exceptions.InvalidVehicleIdException;
import com.rentalmanagement.Exceptions.VehicleNotAvailableException;
import com.rentalmanagement.customers.Customer;
import com.rentalmanagement.vehicles.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {

    @Test
    void testRentVehicle() throws InvalidVehicleIdException, VehicleNotAvailableException {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C1", "Sedan", 50.0, true, true);
        agency.addVehicle(car);

        Customer customer = new Customer("CU1", "John Doe");
        String result = agency.rentVehicle("C1", customer, 2);

        assertEquals("Rental successful! Cost: $100.0 .Loyal Points: 2", result);
        assertFalse(car.isAvailableForRental()); // Vehicle should be rented and unavailable
    }

    @Test
    void testReturnVehicle() throws InvalidVehicleIdException, VehicleNotAvailableException {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C1", "Sedan", 50.0, true, true);
        agency.addVehicle(car);

        Customer customer = new Customer("CU1", "Anthony Gudu");
        agency.rentVehicle("C1", customer, 2);
        String result = agency.returnVehicle("C1");

        assertEquals("Vehicle returned successfully!", result);
        assertTrue(car.isAvailableForRental()); // Vehicle should be available after return
    }

    @Test
    void testLoyaltyPoints() {
        Customer customer = new Customer("CU1", "John Doe");
        customer.addRentalPoints(10);

        assertEquals(10, customer.getLoyaltyPoints());
        assertEquals("Bronze", customer.getLoyaltyStatus());

        customer.addRentalPoints(40);
        assertEquals("Silver", customer.getLoyaltyStatus());
    }

    @Test
    void testVehicleNotAvailableException() throws InvalidVehicleIdException, VehicleNotAvailableException {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C1", "Sedan", 50.0, true, true);
        agency.addVehicle(car);

        // Rent the vehicle
        agency.rentVehicle("C1", new Customer("CU1", "Anthony Gudu"), 2);

        // Try renting the same vehicle again, which should throw an exception
        assertThrows(VehicleNotAvailableException.class, () ->
                agency.rentVehicle("C1", new Customer("CU2", "Jane Doe"), 2));
    }
}
