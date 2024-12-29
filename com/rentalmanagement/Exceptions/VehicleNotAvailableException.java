package com.rentalmanagement.Exceptions;

import java.io.Serial;

/**
 * Custom exception to handle scenarios where a vehicle is not available for rental.
 */
public class VehicleNotAvailableException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L; // Serialization ID

    /**
     * Constructor with a message.
     *
     * @param message The detail message explaining the exception.
     */
    public VehicleNotAvailableException(String message) {
        super(message);
    }

}
