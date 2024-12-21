package com.rentalmanagement.transactions;

import com.rentalmanagement.customers.Customer;
import com.rentalmanagement.vehicles.Vehicle;

public class RentalTransaction {
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private double rentalCost;

    public RentalTransaction(Vehicle vehicle, Customer customer, int days, double rentalCost) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.rentalCost = rentalCost;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "vehicle=" + vehicle +
                ", customer=" + customer +
                ", days=" + days +
                ", rentalCost=" + rentalCost +
                '}';
    }
}
