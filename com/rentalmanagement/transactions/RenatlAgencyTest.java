package com.rentalmanagement.transactions;

import com.rentalmanagement.Exceptions.VehicleNotAvailableException;
import com.rentalmanagement.customers.Customer;
import com.rentalmanagement.vehicles.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {

    @Test
    void testRentVehicle() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C1", "Sedan", 50, true);
        agency.addVehicle(car);

        Customer customer = new Customer("CU1", "John Doe");
        String result = agency.rentVehicle("C1", customer, 2);

        assertEquals("Rental successful! Cost: $100.0", result);
        assertFalse(car.isAvailable());
    }

    @Test
    void testReturnVehicle() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C1", "Sedan", 50, true);
        agency.addVehicle(car);

        Customer customer = new Customer("CU1", "John Doe");
        agency.rentVehicle("C1", customer, 2);
        String result = agency.returnVehicle("C1", 4.5);

        assertEquals("Vehicle returned successfully! Thank you for rating: 4.5", result);
        assertTrue(car.isAvailable());
    }

    @Test
    void testLoyaltyPoints() {
        Customer customer = new Customer("CU1", "John Doe");
        customer.addLoyaltyPoints(10); // Use the correct method name

        assertEquals(10, customer.getLoyaltyPoints());
        assertEquals("Bronze", customer.getLoyaltyStatus());

        customer.addLoyaltyPoints(40); // Use the correct method name
        assertEquals("Silver", customer.getLoyaltyStatus());
    }

    @Test
    void testVehicleNotAvailableException() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C1", "Sedan", 50, true);
        agency.addVehicle(car);

        agency.rentVehicle("C1", new Customer("CU1", "John Doe"), 2);

        assertThrows(VehicleNotAvailableException.class, () ->
                agency.rentVehicle("C1", new Customer("CU2", "Jane Doe"), 2));
    }
}
