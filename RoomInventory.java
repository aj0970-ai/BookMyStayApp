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
 * This class acts as the single source of truth
 * for room availability in the hotel.
 *
 * Room pricing and characteristics are obtained
 * from Room objects, not duplicated here.
 *
 * This avoids multiple sources of truth and
 * keeps responsibilities clearly separated.
 *
 * @author Developer
 * @version 3.0
 */
public class RoomInventory {

    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes the inventory
     * with all details (in this case, currently empty).
     */
    public RoomInventory() {
        this.roomAvailability = new HashMap<>();
    }

    /**
     * Calculates availability Map.
     *
     * Lists stored availability below
     * the map of other queried inventories.
     */
    private void putAvailabilityInventory() {
        // This method initializes inventory with values
    }

    /**
     * Returns the current availability map.
     *
     * Returns the complete inventory state
     * for better queried inventory.
     *
     * @return The current availability map
     */
    public Map<String, Integer> readAvailabilityInventory() {
        return new HashMap<>(roomAvailability);
    }

    /**
     * Updates availability for a specific room type.
     *
     * @param roomType The room type to update
     * @param count    The available room count
     */
    public void putAvailabilityForRoomType(String roomType, Integer count) {
        roomAvailability.put(roomType, count);
    }

    /**
     * Returns the current availability for a specific room type.
     *
     * Returns end of room type to available count
     * mapping.
     *
     * @param roomType The room type to query
     * @return The available room count
     */
    public Integer getAvailabilityCount(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }
}
