/**
 * ===========================================================
 * CLASS - ReservationValidator
 * ===========================================================
 * Validates booking input before processing
 *
 * @version 9.0
 */

public class ReservationValidator {

    /**
     * Validates booking input
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        // Guest name validation
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Room type validation
        if (!(roomType.equalsIgnoreCase("Single") ||
              roomType.equalsIgnoreCase("Double") ||
              roomType.equalsIgnoreCase("Suite"))) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Inventory validation
        if (!inventory.hasAvailableRoom(roomType)) {
            throw new InvalidBookingException("No rooms available for selected type.");
        }
    }
}