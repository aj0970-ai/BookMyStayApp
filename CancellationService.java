import java.util.*;

/**
 * ===========================================================
 * CLASS - CancellationService
 * ===========================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Handles cancellation and restores inventory using LIFO logic.
 *
 * @version 10.0
 */

public class CancellationService {

    /** Stack storing recently released reservation IDs */
    private Stack<String> releasedRoomIds;

    /** Maps reservation ID → room type */
    private Map<String, String> reservationRoomTypeMap;

    /** Constructor */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers confirmed booking
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels booking and restores inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        // Validation: check if booking exists
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid cancellation: Reservation not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        // Rollback: push to stack
        releasedRoomIds.push(reservationId);

        // Restore inventory (+1)
        int current = inventory.getAvailabilityCount(roomType);
        inventory.putAvailabilityForRoomType(roomType, current + 1);

        // Remove from active bookings
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    /**
     * Displays rollback history (LIFO)
     */
    public void showRollbackHistory() {

        System.out.println("\nRollback History (Most Recent First):");

        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.get(i));
        }
    }
}