/**
 * ====================================================
 * MAIN CLASS - UseCase6RoomAllocation
 * ====================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 *
 * It consumes booking requests in FIFO
 * order and updates inventory immediately.
 *
 * @version 6.0
 */
public class UseCase6RoomAllocation {

    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.putAvailabilityForRoomType("SingleRoom", 2);
        inventory.putAvailabilityForRoomType("DoubleRoom", 1);
        inventory.putAvailabilityForRoomType("SuiteRoom", 1);

        BookingRequestQueue requestQueue = new BookingRequestQueue();
        requestQueue.addRequest(new Reservation("Abhi", "Single"));
        requestQueue.addRequest(new Reservation("Subha", "Single"));
        requestQueue.addRequest(new Reservation("Vanathi", "Suite"));

        RoomAllocationService allocationService = new RoomAllocationService();

        System.out.println("Room Allocation Processing");

        while (requestQueue.hasPendingRequests()) {
            Reservation reservation = requestQueue.getNextRequest();
            allocationService.allocateRoom(reservation, inventory);
        }
    }
}
