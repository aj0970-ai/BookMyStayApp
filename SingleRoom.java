/**
 * ===================================================================
 * CLASS - SingleRoom
 * ===================================================================
 *
 * Represents a single room in the hotel.
 *
 * Description:
 * This class specializes the Room abstraction for single-occupancy
 * accommodations. A single room features:
 * - 1 bed
 * - 250 square feet
 * - $1500.0 per night
 *
 * @author Developer
 * @version 2.0
 */
public class SingleRoom extends Room {

    /**
     * Initializes a SingleRoom with
     * predefined attributes.
     */
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}
