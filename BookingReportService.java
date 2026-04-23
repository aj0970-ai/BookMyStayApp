/**
 * ===========================================================
 * CLASS - BookingReportService
 * ===========================================================
 * Use Case 8: Booking History & Reporting
 *
 * Generates reports from booking history.
 *
 * @version 8.0
 */

public class BookingReportService {

    /**
     * Displays summary report of bookings
     * @param history booking history
     */
    public void generateReport(BookingHistory history) {

        System.out.println("\nBooking History Report\n");

        for (Reservation r : history.getConfirmedReservations()) {
            System.out.println("Guest: " + r.getGuestName() +
                               ", Room Type: " + r.getRoomType());
        }
    }
}