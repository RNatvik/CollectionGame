import java.util.HashMap;

public class Room {

    private HashMap<String, Boolean> doors;
    private boolean item;

    public Room() {
        this.doors = new HashMap<>();
        this.item = false;
    }

    public boolean getDoor(String key) {
        boolean door = false;
        if (this.doors.get(key) != null) {
            door = this.doors.get(key);
        }
        return door;
    }

    public void setDoor(String direction) {
        String[] parts = direction.split(", ");
        for (String part : parts) {
            this.doors.put(part, true);
        }
    }

    public boolean hasItem() {
        return this.item;
    }

    public void setItem(boolean item) {
        this.item = item;
    }

}
