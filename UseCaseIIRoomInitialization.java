/**
 * ===================================================================
 * MAIN CLASS - UseCaseIIRoomInitialization
 * ===================================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class demonstrates room initialization using object modeling
 * through inheritance and abstraction. Room objects representing
 * different room types are created with predefined attributes.
 * Availability for each room type is stored using simple variables
 * to highlight the limitations of hardcoded state management.
 *
 * This use case introduces:
 * - Abstract classes for domain modeling
 * - Inheritance and polymorphism
 * - Encapsulation of room attributes
 * - Simple static availability representation
 *
 * @author Developer
 * @version 2.1
 */
public class UseCaseIIRoomInitialization {

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

        // Static availability variables
        int availableSingleRooms = 5;
        int availableDoubleRooms = 3;
        int availableSuiteRooms = 2;

        // Display header
        System.out.println("Hotel Room Initialization\n");

        // Display Single Room details
        System.out.println("Single Room:");
        System.out.println(singleRoom);
        System.out.println("Available: " + availableSingleRooms);

        // Display Double Room details
        System.out.println("\nDouble Room:");
        System.out.println(doubleRoom);
        System.out.println("Available: " + availableDoubleRooms);

        // Display Suite Room details
        System.out.println("\nSuite Room:");
        System.out.println(suiteRoom);
        System.out.println("Available: " + availableSuiteRooms);
    }
}
