 /**
 * ===========================================================
 * CLASS - ConcurrentBookingProcessor
 * ===========================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Processes booking requests using multiple threads safely.
 *
 * @version 11.0
 */

public class ConcurrentBookingProcessor implements Runnable {

    /** Shared queue */
    private BookingRequestQueue bookingQueue;

    /** Shared inventory */
    private RoomInventory inventory;

    /** Shared allocation service */
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService
    ) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            // 🔒 Critical Section 1: Access queue safely
            synchronized (bookingQueue) {
                if (!bookingQueue.hasPendingRequests()) {
                    break;
                }
                reservation = bookingQueue.getNextRequest();
            }

            if (reservation == null) continue;

            // 🔒 Critical Section 2: Allocate room safely
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}