/**
 * ===========================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ===========================================================
 * Use Case 7: Add-On Service Selection
 *
 * Demonstrates attaching optional services to a reservation.
 *
 * @version 7.0
 */

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        // Create manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Reservation ID
        String reservationId = "Single-1";

        // Create services
        Service breakfast = new Service("Breakfast", 500.0);
        Service spa = new Service("Spa", 700.0);
        Service pickup = new Service("Airport Pickup", 300.0);

        // Add services
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);
        manager.addService(reservationId, pickup);

        // Calculate total cost
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        // Output
        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}