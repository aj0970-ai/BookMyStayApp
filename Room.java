/**
 * ===================================================================
 * CLASS - Room
 * ===================================================================
 *
 * Represents a generalized concept of a hotel room.
 *
 * Description:
 * This abstract class defines common attributes and behavior
 * shared by all room types in the hotel. It serves as the
 * blueprint for concrete room implementations such as
 * SingleRoom, DoubleRoom, and SuiteRoom.
 *
 * Room objects encapsulate the characteristics of a room
 * (beds, size, price) while maintaining flexibility for
 * different room specializations through inheritance.
 *
 * @author Developer
 * @version 2.0
 */
public abstract class Room {
    
    private int numberOfBeds;
    private double sizeInSqft;
    private double pricePerNight;

    /**
     * Constructor to initialize a Room with predefined attributes.
     *
     * @param numberOfBeds   The number of beds in the room
     * @param sizeInSqft     The size of the room in square feet
     * @param pricePerNight  The price per night for the room
     */
    public Room(int numberOfBeds, double sizeInSqft, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.sizeInSqft = sizeInSqft;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Gets the number of beds in this room.
     *
     * @return The number of beds
     */
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    /**
     * Gets the size of this room in square feet.
     *
     * @return The size in square feet
     */
    public double getSizeInSqft() {
        return sizeInSqft;
    }

    /**
     * Gets the price per night for this room.
     *
     * @return The price per night
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Returns a string representation of the room.
     *
     * @return A formatted string with room details
     */
    @Override
    public String toString() {
        return "Beds: " + numberOfBeds + 
               ", Size: " + sizeInSqft + " sqft" + 
               ", Price per night: " + pricePerNight;
    }
}
