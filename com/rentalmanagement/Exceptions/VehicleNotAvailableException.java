package com.rentalmanagement.Exceptions;

public class VehicleNotAvailableException extends Exception {
    // Constructor with a message
    public VehicleNotAvailableException(String message) {
        super(message);
    }

    // Constructor with both message and cause
    public VehicleNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with only the cause
    public VehicleNotAvailableException(Throwable cause) {
        super(cause);
    }
}
