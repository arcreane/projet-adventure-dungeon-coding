package game.Dungeon;

import game.Characters.Hero.Hero;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

/**
 * The Dungeon class represents a dungeon consisting of multiple rooms.
 * It manages the hero's journey through the rooms and monitors the hero's status.
 * Implements PropertyChangeListener to react to events, such as changes in the hero's state.
 */

public class Dungeon implements PropertyChangeListener {
	/**
	 * An array of rooms that make up the dungeon.
	 */
    private final Room[] rooms;

	/**
	 * Creates a new Dungeon with the specified number of rooms.
	 * Each room is initialized with its own monster.
	 *
	 * @param numberRooms The number of rooms in the dungeon.
	 */

	public Dungeon(int numberRooms) {
		// Initialization of rooms with their monster
		// Initialize the array of rooms with the specified number.
        rooms = new Room[numberRooms];
		for(int i = 0; i < numberRooms; i++){
			rooms[i] = new Room();
			System.out.println("Room " + i + " created");
		}
	}
	public List<Room> room;

	/**
	 * Allows the hero to enter the dungeon and navigate through its rooms.
	 * The hero fights monsters in each room until they either defeat all monsters or die.
	 *
	 * @param hero The hero entering the dungeon.
	 */
    public void letEnter(Hero hero) {
		//System.out.println("-- game.Dungeon Monster --\n");
		// Loop through all rooms in the dungeon.
		for(int i = 0 ; i < rooms.length ; i ++){
			// Notify the hero of their current room and health points.
			System.out.println("You are in the room " + (i + 1) + " with "+ hero.getHealthPoints()+ " health points");
			// The hero enters the room and fights the monster.
			rooms[i].enterRoom(hero);

			// If the hero dies, the loop breaks, and the game ends.
			if(!hero.isAlive()) {
				System.out.println("Too bad you're dead");
				break;
			}
		}
		// Check if the hero has survived all rooms and won the game.
		if (hero.isAlive()) {
			System.out.println("Congratulations! You have completed all the rooms, you find treasure and won the game!");
		}
    }
	/**
	 * Reacts to property changes, such as events from the hero.
	 * Currently, this method is empty and needs implementation based on the game's requirements.
	 *
	 * @param evt The property change event triggered by an observable object.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// No specific behavior defined yet for property change events.
	}
}