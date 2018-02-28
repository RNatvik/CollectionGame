import java.util.HashMap;

public class Room {

    private HashMap<String, Boolean> doors;
    private boolean item;

    /**
     * Constructor
     */
    public Room() {
        this.doors = new HashMap<>();
        this.item = false;
    }

    /**
     * Checks for available door
     * @param key the key to check for available door
     * @return true if @param key is linked to a value, false if not
     */
    public boolean getDoor(String key) {
        boolean door = false;
        if (this.doors.get(key) != null) {
            door = this.doors.get(key);
        }
        return door;
    }

    /**
     * Sets the room's available doors.
     * Use ", " to split keywords for setting multiple doors in one call
     * @param direction the key to map a value to (can include regex ", ")
     */
    public void setDoor(String direction) {
        String[] parts = direction.split(", ");
        for (String part : parts) {
            this.doors.put(part, true);
        }
    }

    /**
     * @return true if room has item
     */
    public boolean hasItem() {
        return this.item;
    }

    /**
     * set this room's boolean "item"
     * @param item true or false
     */
    public void setItem(boolean item) {
        this.item = item;
    }

}
