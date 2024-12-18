package com.rentalmanagement.Exceptions;

public class InvalidVehicleIdException extends Exception {
    // Constructor with a message
    public InvalidVehicleIdException(String message) {
        super(message);
    }

    // Constructor with both message and cause
    public InvalidVehicleIdException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with only the cause
    public InvalidVehicleIdException(Throwable cause) {
        super(cause);
    }
}
