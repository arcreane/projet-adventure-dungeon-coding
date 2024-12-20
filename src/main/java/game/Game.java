package game;

import game.Characters.Hero.Hero;
import game.Dungeon.Dungeon;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Scanner;
/**
 * The main class for the Dungeon game.
 * This class initializes the game, handles user input, and manages the game flow.
 * Implements PropertyChangeListener to respond to changes in the hero's properties (e.g., when the hero dies).
 */

public class Game implements PropertyChangeListener {
    /**
     * A static Scanner instance for reading user input from the console.
     */
    public static Scanner sc = new Scanner(System.in);
    /**
     * The entry point of the program.
     * Initializes a new Game instance and starts the game.
     *
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
    /**
     * Starts the game by initializing the dungeon, the hero, and their interactions.
     * Displays introductory messages and lets the hero enter the dungeon.
     */

    private void startGame() {

//        System.out.println("Select difficulty : \n\t- type 1 for easy (5 rooms)\n\t- type 2 for medium (10 rooms)\n\t- type 3 for hard (15 rooms)");
//        String answer = sc.nextLine().toLowerCase();
//        switch (answer) {
//            case "1": 5 rooms; break;
//            case "2": 10 rooms; break;
//            case "3": 15 rooms; break;
//            default: System.out.println("Invalid input");
        //get the user input and make a switch in a while so that you have
        //a coherent answer
        // game.Dungeon initialization (parameters number of rooms)

        // Currently, the dungeon is initialized with 5 rooms by default.
        Dungeon dungeon = new Dungeon(5);

        // Initialize the hero with a name and subscribe listeners to its "isAlive" property.
        Hero hero = new Hero("Jenna the Warrior");
        hero.subscribe("isAlive", this);
        hero.subscribe("isAlive", dungeon);

        // Display welcome messages.
        System.out.println("Welcome to the Dungeon !");
        System.out.println("Are you ready to DIE ?");

        // Let the hero enter the dungeon.
        dungeon.letEnter(hero);
    }
    /**
     * Ends the game and prompts the player to restart or exit.
     * If the player chooses to play again, the game restarts; otherwise, the program exits.
     */
    public void gameOver() {
        System.out.println("Game Over");
        String answer = "";
        do {
            System.out.println("Do you want to play again? Y or N ?");
            answer = sc.nextLine().toLowerCase();
        } while (!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")));
        switch (answer) {
            case "y":
                startGame(); // Restart the game
                break;
            case "n":
                System.exit(0); // Exit the program
            default:
                System.out.println("Bad answer."); // Should not reach here due to the loop
        }
        }
    }
/**
 * Handles property change events from observable objects, such as the hero.
 * If the hero's "isAlive" property changes, the game ends.
 *
 * @param evt The property change event that triggered this method.
 */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!Hero.Fields.isAlive.equals(evt.getPropertyName())) {
            gameOver();
        }

    }
}