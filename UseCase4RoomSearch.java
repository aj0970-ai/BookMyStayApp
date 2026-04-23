/**
 * ===================================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ===================================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class demonstrates how guests can search
 * for available rooms without modifying system state.
 *
 * Read-only access ensures inventory consistency
 * and prevents unintended side effects.
 *
 * The system enforces read-only access
 * by design and usage discipline.
 *
 * @author Developer
 * @version 4.0
 */
public class UseCase4RoomSearch {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Create centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Register room types with their available counts
        inventory.putAvailabilityForRoomType("SingleRoom", 5);
        inventory.putAvailabilityForRoomType("DoubleRoom", 3);
        inventory.putAvailabilityForRoomType("SuiteRoom", 2);

        // Create search service
        RoomSearchService searchService = new RoomSearchService();

        // Display header
        System.out.println("Room Search\n");

        // Perform search for available rooms
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom);
    }
}
