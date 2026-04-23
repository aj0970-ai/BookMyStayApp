/**
 
 * @param inventory centralized room inventory
 * @param singleRoom single room definition
 * @param doubleRoom double room definition
 * @param suiteRoom suite room definition
 *
 * @author Developer
 * @version 4.0
 */
public class RoomSearchService {

    /**
     * Displays available rooms along with
     * their details and pricing.
     *
     * @param inventory inventory centralized room inventory
     * to inventory and room data.
     *
     * @param inventory inventory centralized room inventory
     * @param singleRoom single room definition
     * @param doubleRoom double room definition
     * @param suiteRoom suite room definition
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        // Check and display single room availability
        if (inventory.getAvailabilityCount("SingleRoom") > 0) {
            System.out.println("Single Room:");
            System.out.println(singleRoom);
            System.out.println("Available: " + inventory.getAvailabilityCount("SingleRoom"));
            System.out.println();
        }

        // Check and display double room availability
        if (inventory.getAvailabilityCount("DoubleRoom") > 0) {
            System.out.println("Double Room:");
            System.out.println(doubleRoom);
            System.out.println("Available: " + inventory.getAvailabilityCount("DoubleRoom"));
            System.out.println();
        }

        // Check and display suite room availability
        if (inventory.getAvailabilityCount("SuiteRoom") > 0) {
            System.out.println("Suite Room:");
            System.out.println(suiteRoom);
            System.out.println("Available: " + inventory.getAvailabilityCount("SuiteRoom"));
            System.out.println();
        }
    }
}
