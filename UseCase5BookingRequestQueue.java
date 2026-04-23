/**
 * ====================================================
 * MAIN CLASS – UseCase5BookingRequestQueue
 * ====================================================
 *
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Description:
 * This class demonstrates now booking
 * requests are accepted and queued
 * in a fair and predictable order.
 *
 * No room allocation or inventory
 * update is performed here.
 *
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {

    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Initialize booking request queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulate guest booking requests
        System.out.println("=== Booking Request Queue Demo ===\n");

        // Adding requests in arrival order
        bookingQueue.addRequest(new Reservation("Alice", "Single"));
        System.out.println("✓ Request from Alice (Single Room) added to queue");

        bookingQueue.addRequest(new Reservation("Bob", "Double"));
        System.out.println("✓ Request from Bob (Double Room) added to queue");

        bookingQueue.addRequest(new Reservation("Charlie", "Suite"));
        System.out.println("✓ Request from Charlie (Suite Room) added to queue");

        System.out.println("\n--- Processing Requests in FIFO Order ---\n");

        // Process requests in order
        while (bookingQueue.hasPendingRequests()) {
            Reservation reservation = bookingQueue.getNextRequest();
            System.out.println("Processing: " + reservation.getGuestName() 
                    + " - Room Type: " + reservation.getRoomType());
        }

        System.out.println("\n✓ All requests processed.");
    }
}
