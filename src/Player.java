public class Player {

    private String name;
    private Room currentRoom;
    private int itemCounter;
    private int currentX;
    private int currentY;

    public Player() {
        this.name = "";
        this.currentRoom = new Room();
        this.itemCounter = 0;
        this.currentX = 0;
        this.currentY = 0;
    }

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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }

    public void incrementItemCounter() {
        this.itemCounter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getItemCounter() {
        return this.itemCounter;
    }

    public int getCurrentX() {
        return this.currentX;
    }

    public int getCurrentY() {
        return this.currentY;
    }

    public void setPosition(int x, int y) {
        this.currentX = x;
        this.currentY = y;
    }

}
