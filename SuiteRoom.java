/**
 * ===================================================================
 * CLASS - SuiteRoom
 * ===================================================================
 *
 * Represents a suite room in the hotel.
 *
 * Description:
 * This class specializes the Room abstraction for premium
 * accommodations. A suite room features:
 * - 3 beds
 * - 750 square feet
 * - $5000.0 per night
 *
 * @author Developer
 * @version 2.0
 */
public class SuiteRoom extends Room {

    /**
     * Initializes a SuiteRoom with
     * predefined attributes.
     */
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}
