package com.rentalmanagement.transactions;

import com.rentalmanagement.Exceptions.InvalidVehicleIdException;
import com.rentalmanagement.Exceptions.VehicleNotAvailableException;
import com.rentalmanagement.customers.Customer;
import com.rentalmanagement.vehicles.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {

    @Test
    void testRentVehicle() throws InvalidVehicleIdException {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C1", "Sedan",50.0, true, true);
        agency.addVehicle(car);

        Customer customer = new Customer("CU1", "John Doe");
        String result = agency.rentVehicle("C1", customer, 2);

        assertEquals("Rental successful! Cost: $100.0 .Loyal Points: 2", result);
        assertFalse(car.isAvailableForRental()); // Correct method name to check availability
    }

    @Test
    void testReturnVehicle() throws InvalidVehicleIdException {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C1", "Sedan", 50, true, true);
        agency.addVehicle(car);

        Customer customer = new Customer("CU1", "Anthony Gudu");
        agency.rentVehicle("C1", customer, 2);
        String result = agency.returnVehicle("C1");

        assertEquals("Vehicle returned successfully!", result);
        assertTrue(car.isAvailableForRental()); // Correct method name to check availability
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
    void testVehicleNotAvailableException() throws InvalidVehicleIdException {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C1", "Sedan", 50, true, true);
        agency.addVehicle(car);

        agency.rentVehicle("C1", new Customer("CU1", "Anthony Gudu"), 2);

        assertThrows(VehicleNotAvailableException.class, () ->
                agency.rentVehicle("C1", new Customer("CU2", "Jane Doe"), 2));
    }
}
