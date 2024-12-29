package com.rentalmanagement.Exceptions;

/**
 * Custom exception to handle scenarios where a vehicle is not available for rental.
 */
public class VehicleNotAvailableException extends Exception {
    private static final long serialVersionUID = 1L; // Serialization ID

    /**
     * Constructor with a message.
     *
     * @param message The detail message explaining the exception.
     */
    public VehicleNotAvailableException(String message) {
        super(message);
    }

    /**
     * Constructor with a message and a cause.
     *
     * @param message The detail message explaining the exception.
     * @param cause   The cause of the exception (can be null).
     */
    public VehicleNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with only the cause.
     *
     * @param cause The cause of the exception (can be null).
     */
    public VehicleNotAvailableException(Throwable cause) {
        super(cause);
    }
}
