package com.rentalmanagement.transactions;

import com.rentalmanagement.customers.Customer;
import com.rentalmanagement.vehicles.Vehicle;

public class RentalTransaction {
    private Vehicle vehicle;
    private Customer customer;
    private int rentalDays;
    private double totalCost;

    public RentalTransaction(Vehicle vehicle, Customer customer, int rentalDays, double totalCost) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDays = rentalDays;
        this.totalCost = totalCost;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "vehicle=" + vehicle +
                ", customer=" + customer +
                ", rentalDays=" + rentalDays +
                ", totalCost=" + totalCost +
                '}';
    }
}
