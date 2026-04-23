/**
 * ===========================================================
 * CLASS - InvalidBookingException
 * ===========================================================
 * Use Case 9: Error Handling & Validation
 *
 * Custom exception for invalid booking scenarios
 *
 * @version 9.0
 */

public class InvalidBookingException extends Exception {

    /**
     * Creates exception with message
     * @param message error description
     */
    public InvalidBookingException(String message) {
        super(message);
    }
}