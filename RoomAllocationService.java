import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ====================================================
 * CLASS - RoomAllocationService
 * ====================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class is responsible for confirming
 * booking requests and assigning rooms.
 *
 * It ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double-booked
 *
 * @version 6.0
 */
public class RoomAllocationService {

    /** Stores all allocated room IDs to prevent duplicate assignments. */
    private Set<String> allocatedRoomIds;

    /** Stores assigned room IDs grouped by room type. */
    private Map<String, Set<String>> assignedRoomsByType;

    /** Initializes allocation tracking structures. */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning
     * a unique room ID and updating inventory.
     *
     * @param reservation booking request
     * @param inventory centralized room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String normalizedType = normalizeRoomType(reservation.getRoomType());
        String inventoryKey = normalizedType + "Room";

        if (inventory.getAvailabilityCount(inventoryKey) <= 0) {
            System.out.println("Booking could not be confirmed for Guest: "
                    + reservation.getGuestName() + " (No " + normalizedType + " rooms available)");
            return;
        }

        String roomId = generateRoomId(normalizedType);
        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(normalizedType, key -> new HashSet<>())
                .add(roomId);

        inventory.decrementAvailabilityForRoomType(inventoryKey);

        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    /**
     * Generates a unique room ID for
     * the given room type.
     *
     * @param roomType type of room
     * @return unique room ID
     */
    private String generateRoomId(String roomType) {
        int index = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        String generatedId = roomType + "-" + index;
        while (allocatedRoomIds.contains(generatedId)) {
            index++;
            generatedId = roomType + "-" + index;
        }

        return generatedId;
    }

    /**
     * Converts supported room labels into canonical room type names.
     *
     * @param roomType requested room type
     * @return canonical room type name used by allocation
     */
    private String normalizeRoomType(String roomType) {
        if (roomType == null) {
            return "Unknown";
        }

        String cleaned = roomType.trim().toLowerCase();
        switch (cleaned) {
            case "single":
            case "singleroom":
                return "Single";
            case "double":
            case "doubleroom":
                return "Double";
            case "suite":
            case "suiteroom":
                return "Suite";
            default:
                return roomType;
        }
    }
}
