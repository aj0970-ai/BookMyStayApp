import java.util.LinkedList;
import java.util.Queue;

/**
 * ====================================================
 * CLASS – BookingRequestQueue
 * ====================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * Manages booking requests using FIFO queue.
 *
 * Integrated with:
 * Use Case 9 - Safe handling & validation support
 *
 * @version 5.1
 */
public class BookingRequestQueue {

    /** Queue storing booking requests */
    private Queue<Reservation> requestQueue;

    /** Initializes empty queue */
    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /**
     * Adds a booking request to queue
     *
     * @param reservation booking request
     */
    public void addRequest(Reservation reservation) {
        if (reservation == null) {
            System.out.println("Cannot add null booking request.");
            return;
        }
        requestQueue.offer(reservation);
    }

    /**
     * Retrieves and removes next request
     *
     * @return next reservation OR null
     */
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    /**
     * Returns next request WITHOUT removing it
     *
     * @return next reservation OR null
     */
    public Reservation peekNextRequest() {
        return requestQueue.peek();
    }

    /**
     * Checks if queue has pending requests
     *
     * @return true if not empty
     */
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }

    /**
     * Returns number of pending requests
     *
     * @return queue size
     */
    public int getQueueSize() {
        return requestQueue.size();
    }
}