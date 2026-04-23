/**
 * ===================================================================
 * CLASS - DoubleRoom
 * ===================================================================
 *
 * Represents a double room in the hotel.
 *
 * Description:
 * This class specializes the Room abstraction for double-occupancy
 * accommodations. A double room features:
 * - 2 beds
 * - 400 square feet
 * - $2500.0 per night
 *
 * @author Developer
 * @version 2.0
 */
public class DoubleRoom extends Room {

    /**
     * Initializes a DoubleRoom with
     * predefined attributes.
     */
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}
