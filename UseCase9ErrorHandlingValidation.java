import java.util.Scanner;

/**
 * ===========================================================
 * MAIN CLASS - UseCase9ErrorHandlingValidation
 * ===========================================================
 * Demonstrates validation and error handling
 *
 * @version 9.0
 */

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            // Input
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validation (FAIL-FAST)
            validator.validate(guestName, roomType, inventory);

            // If validation passes
            System.out.println("Booking request is valid.");

        } catch (InvalidBookingException e) {
            // Graceful failure
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}