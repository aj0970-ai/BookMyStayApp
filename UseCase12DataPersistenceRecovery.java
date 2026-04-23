/**
 * ===========================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * ===========================================================
 *
 * Demonstrates persistence and recovery
 *
 * @version 12.0
 */

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        String filePath = "inventory.txt";

        // Create components
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();

        // Load saved data
        persistence.loadInventory(inventory, filePath);

        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getAvailabilityCount("Single"));
        System.out.println("Double: " + inventory.getAvailabilityCount("Double"));
        System.out.println("Suite: " + inventory.getAvailabilityCount("Suite"));

        // Save inventory back
        persistence.saveInventory(inventory, filePath);
    }
}