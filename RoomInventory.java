import java.util.HashMap;
import java.util.Map;

/**
 * ===================================================================
 * CLASS - RoomInventory
 * ===================================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * Single source of truth for room availability.
 *
 * Integrated with:
 * Use Case 9 - Validation support (availability checks)
 *
 * @version 3.1
 */
public class RoomInventory {

    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes inventory with default values
     */
    public RoomInventory() {
        this.roomAvailability = new HashMap<>();

        // Default room availability
        roomAvailability.put("Single", 2);
        roomAvailability.put("Double", 2);
        roomAvailability.put("Suite", 1);
    }

    /**
     * Returns a copy of full availability map
     *
     * @return availability map
     */
    public Map<String, Integer> readAvailabilityInventory() {
        return new HashMap<>(roomAvailability);
    }

    /**
     * Updates availability for a room type
     *
     * @param roomType room type
     * @param count    available count
     */
    public void putAvailabilityForRoomType(String roomType, Integer count) {
        roomAvailability.put(roomType, count);
    }

    /**
     * Returns available count for a room type
     *
     * @param roomType room type
     * @return available rooms
     */
    public Integer getAvailabilityCount(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    /**
     * Checks if room is available
     *
     * @param roomType room type
     * @return true if available
     */
    public boolean hasAvailableRoom(String roomType) {
        return getAvailabilityCount(roomType) > 0;
    }

    /**
     * Decrements availability if possible
     *
     * @param roomType room type
     * @return true if successful
     */
    public boolean decrementAvailabilityForRoomType(String roomType) {
        int available = getAvailabilityCount(roomType);

        if (available <= 0) {
            return false;
        }

        roomAvailability.put(roomType, available - 1);
        return true;
    }
}