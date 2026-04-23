/**
 * ===========================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ===========================================================
 *
 * Demonstrates cancellation and rollback
 *
 * @version 10.0
 */

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Service
        CancellationService service = new CancellationService();

        // Simulate confirmed booking
        String reservationId = "Single-1";
        String roomType = "Single";

        // Register booking
        service.registerBooking(reservationId, roomType);

        // Assume booking consumed one room earlier
        inventory.decrementAvailabilityForRoomType(roomType);

        // Cancel booking
        service.cancelBooking(reservationId, inventory);

        // Show rollback history
        service.showRollbackHistory();

        // Show updated availability
        System.out.println("\nUpdated Single Room Availability: " +
                inventory.getAvailabilityCount(roomType));
    }
}