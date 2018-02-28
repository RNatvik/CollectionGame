import java.util.Scanner;

public class ApplicationUI {

    private Maze maze;
    private Player player;

    private String[] welcomeMenu = {
            "Welcome to this amazing game!",
            "Your teacher has forgot some of his items in the basement.",
            "He has commanded you to retrieve them, but as you entered the basement",
            "the lights all went out.",
            "Fumbling blind in the dark you try to locate these items.",
            "You won't be able to leave the basement before you locate ALL items.",
            "If you do, you'll get an F on your next assignment",
            "Good luck, and try not to bump into too many walls",
            ""
    };

    private String[] availableLevelsMenu = {
            "1. 'level 1'"
    };

    /**
     * Constructor
     */
    public ApplicationUI() {
        this.maze = new Maze();
        this.player = new Player();
    }

    /**
     * startUp for ApplicationUI. Only public accessible method for this UI
     * Rest of program will be run through console inside ApplicationUI
     */
    public void startUp() {
        Scanner scanner = new Scanner(System.in);

        this.printMenu(this.welcomeMenu);

        System.out.println("Please enter player name: ");
        String name = scanner.nextLine();
        this.player.setName(name);

        System.out.println("Hello, " + this.player.getName() + ". Please enter which level you want to play:");
        this.printMenu(this.availableLevelsMenu);

        boolean finished = false;
        int choice = 0;
        while (!finished) {
            finished = true;
            boolean validInput = false;
            while (!validInput) {
                try {
                    String input = scanner.nextLine();
                    choice = Integer.parseInt(input);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please type an Integer");
                }
            }
            switch (choice) {
                case 1:
                    System.out.println("Generating level 1...");
                    this.maze.createMaze(choice);
                    System.out.println("Generated successfully");
                    break;

                default:
                    System.out.println("that is not an available level, please try again");
                    finished = false;
                    break;
            }
        }
        this.player.setPosition(this.maze.getStartX(), this.maze.getStartY());
        this.player.setCurrentRoom(this.maze.getRoomAt(this.maze.getStartX(), this.maze.getStartY()));
        System.out.println("Now entering chosen level");
        this.runGame();
    }

    /**
     * The main loop for running the game. Asks for input and gives feedback
     */
    private void runGame() {

        this.printInitialInformation();
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {

            System.out.println("Please enter a direction to move (west, east, north, south)");
            String input = scanner.next().toLowerCase();

            if (currentRoomHasDoor(input)) {
                this.player.move(input);
                this.setPlayerCurrentRoom();
                System.out.println("Great success! You can go this way");
            } else if (input.equals("west") || input.equals("east") || input.equals("north") || input.equals("south") ) {
                this.player.setPosition(this.maze.getStartX(), this.maze.getStartY());
                this.setPlayerCurrentRoom();
                System.out.println("Uh-oh... You bumped into a wall... ");
            } else if (input.equals(".exit")){
                quit = true;
                System.out.println("You give up i see. Too bad. Have fun with an F on your next assignment");
            } else {
                System.out.println(input + " is not a valid input, use (west, east, north, south)");
            }

            System.out.println("Current location: (" + this.player.getCurrentX() + " / " + this.player.getCurrentY() + ")");
            Room currentRoom = this.player.getCurrentRoom();
            if (currentRoom.hasItem()) {
                this.maze.decreaseItemsRemaining();
                currentRoom.setItem(false);
                System.out.println("YOU FOUND AN ITEM! You now only have " + this.maze.getItemsRemaining() + " left to find!");
            }
            if (this.maze.getItemsRemaining() == 0 && this.player.getCurrentX() == this.maze.getGoalX() && this.player.getCurrentY() == this.maze.getGoalY()) {
                System.out.println("You found all items, AND managed to get out. Get a life nerd! xDDDD lolololo");
                quit = true;
            } else if (this.player.getCurrentX() == this.maze.getGoalX() && this.player.getCurrentY() == this.maze.getGoalY()) {
                System.out.println("You can't leave yet! Your teacher would be furious if you return without all his items!");
            }
            System.out.println();
        }

    }

    /**
     * Support method for checking for valid direction
     * @param direction the wanted direction to move
     * @return true: if player's current room has door @param direction. Else, return false.
     */
    private boolean currentRoomHasDoor(String direction) {
        return this.player.getCurrentRoom().getDoor(direction);
    }

    /**
     * Support method for setting player's current room
     */
    private void setPlayerCurrentRoom() {
        this.player.setCurrentRoom(this.maze.getRoomAt(this.player.getCurrentX(), this.player.getCurrentY()));
    }

    /**
     * Prints useful information to user at start of the game
     */
    private void printInitialInformation() {
        System.out.println("Your start location (x / y) is: (" + this.maze.getStartX() + " / " + this.maze.getStartY() + ")");
        System.out.println("You will return here if you bump into a wall, due to quantum physics and magic.");
        System.out.println();
        System.out.println("Your exit is located at (x / y): (" + this.maze.getGoalX() + " / " + this.maze.getGoalY() + ")");
        System.out.println("This is where you will need to go after you find all your teacher's items");
        System.out.println("If you for some reason want to quit the application, " +
                "simply write .exit when prompted for direction");
    }

    /**
     * prints all parts of a String[] on separate lines to user.
     * @param menu the String[]
     */
    private void printMenu(String[] menu) {
        for (String part : menu) {
            System.out.println(part);
        }
    }
}
