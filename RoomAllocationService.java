import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ====================================================
 * CLASS - RoomAllocationService
 * ====================================================
 *
 * Use Case 6 + 11 Compatible
 *
 * Handles room allocation safely and uniquely.
 *
 * @version 6.1
 */
public class RoomAllocationService {

    /** Prevent duplicate room IDs */
    private Set<String> allocatedRoomIds;

    /** Tracks assigned rooms by type */
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Allocates a room safely
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String normalizedType = normalizeRoomType(reservation.getRoomType());

        // ✅ FIX: Use correct inventory key
        if (!inventory.hasAvailableRoom(normalizedType)) {
            System.out.println("Booking could not be confirmed for Guest: "
                    + reservation.getGuestName()
                    + " (No " + normalizedType + " rooms available)");
            return;
        }

        String roomId = generateRoomId(normalizedType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(normalizedType, key -> new HashSet<>())
                .add(roomId);

        // ✅ Correct decrement
        inventory.decrementAvailabilityForRoomType(normalizedType);

        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    /**
     * Generates unique room ID
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
     * Normalizes room type
     */
    private String normalizeRoomType(String roomType) {

        if (roomType == null) return "Unknown";

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