/**
 * ===================================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ===================================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class demonstrates how room availability
 * is managed using a centralized inventory.
 *
 * Room objects are used to retrieve pricing
 * and room characteristics.
 *
 * No booking or search logic is introduced here.
 *
 * @author Developer
 * @version 3.1
 */
public class UseCase3InventorySetup {

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

        // Display header
        System.out.println("Hotel Room Inventory Status\n");

        // Display Single Room details
        System.out.println("Single Room:");
        System.out.println(singleRoom);
        System.out.println("Available Rooms: " + inventory.getAvailabilityCount("SingleRoom"));

        // Display Double Room details
        System.out.println("\nDouble Room:");
        System.out.println(doubleRoom);
        System.out.println("Available Rooms: " + inventory.getAvailabilityCount("DoubleRoom"));

        // Display Suite Room details
        System.out.println("\nSuite Room:");
        System.out.println(suiteRoom);
        System.out.println("Available Rooms: " + inventory.getAvailabilityCount("SuiteRoom"));
    }
}
