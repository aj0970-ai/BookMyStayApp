/**
 * ===========================================================
 * MAIN CLASS - UseCase11ConcurrentBookingSimulation
 * ===========================================================
 *
 * Demonstrates concurrent booking
 *
 * @version 11.0
 */

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation\n");

        // Shared resources
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Add booking requests
        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Double"));
        bookingQueue.addRequest(new Reservation("Vannathi", "Double"));
        bookingQueue.addRequest(new Reservation("Kunal", "Suite"));

        // Create threads
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        // Start threads
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // Print remaining inventory
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.getAvailabilityCount("Single"));
        System.out.println("Double: " + inventory.getAvailabilityCount("Double"));
        System.out.println("Suite: " + inventory.getAvailabilityCount("Suite"));
    }
}