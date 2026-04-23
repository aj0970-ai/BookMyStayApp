import java.util.*;

/**
 * ===========================================================

 * Supports attaching multiple services to a reservation.
 *
 * @version 7.0
 */

public class AddOnServiceManager {

    /**
     * Maps reservation ID to selected services
     * Key   -> Reservation ID
     * Value -> List of services
     */
    private Map<String, List<Service>> servicesByReservation;

    /** Initializes the service manager */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Adds a service to a reservation
     * @param reservationId reservation ID
     * @param service add-on service
     */
    public void addService(String reservationId, Service service) {
        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    /**
     * Calculates total add-on cost for a reservation
     * @param reservationId reservation ID
     * @return total cost
     */
    public double calculateTotalServiceCost(String reservationId) {
        double total = 0.0;

        List<Service> services = servicesByReservation.get(reservationId);

        if (services != null) {
            for (Service s : services) {
                total += s.getCost();
            }
        }

        return total;
    }
}