import java.util.ArrayList;

public class Maze {

    private ArrayList<ArrayList<Room>> rooms; //Two dimensional ArrayList for rooms
    private int startX;
    private int startY;
    private int goalX;
    private int goalY;
    private int itemsRemaining;

    /**
     * Constructor with default values
     */
    public Maze() {
        this.startX = 0;
        this.startY = 0;
        this.goalX = 0;
        this.goalY = 0;
        this.rooms = new ArrayList<>();
    }

    /**
     * Gets the room located at ArrayList[y] in ArrayList[x]
     * @param x the index in outer ArrayList
     * @param y the index in inner ArrayList
     * @return the room located at x/y
     */
    public Room getRoomAt(int x, int y) {
        Room room = new Room();
        room = this.rooms.get(x).get(y);
        return room;
    }

    /**
     * Gets amount of items remaining in the maze
     * @return amount of items
     */
    public int getItemsRemaining() {
        return this.itemsRemaining;
    }

    /**
     * Decreases itemsRemaining by 1
     */
    public void decreaseItemsRemaining() {
        this.itemsRemaining--;
    }

    /**
     * Gets the start position for x
     * @return start position for x
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Gets the start position for y
     * @return start position for y
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Gets the goal position for x
     * @return goal position for x
     */
    public int getGoalX() {
        return goalX;
    }

    /**
     * Gets the goal position for y
     * @return goal position for y
     */
    public int getGoalY() {
        return goalY;
    }

    /**
     * Method collection for creation of different mazes
     * @param level the maze to create
     */
    public void createMaze(int level) {
        if (level == 1) {
            this.createLevelOne();
        }
    }

    /**
     * Layout for Level 1
     */
    private void createLevelOne() {
        for (int i = 0; i < 5; i++) {
            this.rooms.add(new ArrayList<>());
        }
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                this.rooms.get(x).add(new Room());
            }
        }
        this.rooms.get(0).get(0).setDoor("north, east");
        this.rooms.get(0).get(1).setDoor("north, south");
        this.rooms.get(0).get(2).setDoor("north, east, south");
        this.rooms.get(0).get(3).setDoor("north, south");
        this.rooms.get(0).get(4).setDoor("south, east");

        this.rooms.get(1).get(0).setDoor("west, east");
        this.rooms.get(1).get(1).setDoor("north, east");
        this.rooms.get(1).get(2).setDoor("north, south, west");
        this.rooms.get(1).get(3).setDoor("south, east");
        this.rooms.get(1).get(4).setDoor("west");

        this.rooms.get(2).get(0).setDoor("north, east, west");
        this.rooms.get(2).get(1).setDoor("south, west, east");
        this.rooms.get(2).get(2).setDoor("north");
        this.rooms.get(2).get(3).setDoor("north, west, south");
        this.rooms.get(2).get(4).setDoor("south, east");

        this.rooms.get(3).get(0).setDoor("west");
        this.rooms.get(3).get(1).setDoor("north, east, west");
        this.rooms.get(3).get(2).setDoor("south");
        this.rooms.get(3).get(3).setDoor("east");
        this.rooms.get(3).get(4).setDoor("west, east");

        this.rooms.get(4).get(0).setDoor("north");
        this.rooms.get(4).get(1).setDoor("north, west, south");
        this.rooms.get(4).get(2).setDoor("south");
        this.rooms.get(4).get(3).setDoor("north, west");
        this.rooms.get(4).get(4).setDoor("south, west");

        this.rooms.get(0).get(0).setItem(true);
        this.rooms.get(1).get(4).setItem(true);
        this.rooms.get(2).get(2).setItem(true);
        this.rooms.get(4).get(0).setItem(true);
        this.rooms.get(4).get(3).setItem(true);

        this.startX = 1;
        this.startY = 1;
        this.goalX = 3;
        this.goalY = 3;
        this.itemsRemaining = 5;

    }


}
