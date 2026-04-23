import java.util.*;

/**
 * ===========================================================
 * CLASS - BookingHistory
 * ===========================================================
 * Use Case 8: Booking History & Reporting
 *
 * Maintains record of confirmed reservations
 * in insertion order.
 *
 * @version 8.0
 */

public class BookingHistory {

    /** List storing confirmed reservations */
    private List<Reservation> confirmedReservations;

    /** Initializes empty booking history */
    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    /**
     * Adds a confirmed reservation
     * @param reservation confirmed reservation
     */
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    /**
     * Returns all confirmed reservations
     * @return list of reservations
     */
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}