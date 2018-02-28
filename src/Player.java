/**
 * A class representing a single player.
 * Keeps track of current x/y location
 * Also keeps track of how many items are found
 */
public class Player {

    private String name;
    private Room currentRoom;
    private int currentX;
    private int currentY;

    /**
     * Constructor
     */
    public Player() {
        this.name = "";
        this.currentRoom = new Room();
        this.currentX = 0;
        this.currentY = 0;
    }

    /**
     * Increments current x/y position based on direction parameter
     * @param direction the direction to move
     */
    public void move(String direction) {
        if (direction.equals("north")) {
            this.currentY++;
        } else if (direction.equals("south")) {
            this.currentY--;
        } else if (direction.equals("east")) {
            this.currentX++;
        } else if (direction.equals("west")) {
            this.currentX--;
        }
    }

    /**
     * Returns the player's current room
     * @return the current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the player's current room
     * @param newRoom the new room
     */
    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }

    /**
     * Sets the player's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the player's name
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * gets the player's current x position
     * @return current x position
     */
    public int getCurrentX() {
        return this.currentX;
    }

    /**
     * gets the player's current y position
     * @return current y position
     */
    public int getCurrentY() {
        return this.currentY;
    }

    /**
     * Sets the player's x/y position
     * @param x x location
     * @param y y location
     */
    public void setPosition(int x, int y) {
        this.currentX = x;
        this.currentY = y;
    }

}
