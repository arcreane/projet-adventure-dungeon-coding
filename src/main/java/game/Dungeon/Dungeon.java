package game.Dungeon;

import game.Characters.Hero.Hero;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import game.Game;

public class Dungeon implements PropertyChangeListener {
	private final Room[] rooms;
	private static final String ANSI_RED = "\u001B[36m";
	private static final String ANSI_RESET = "\u001B[0m";

	public Dungeon(int numberRooms) {
		// Initialization of rooms with their monster
		rooms = new Room[numberRooms];
		for (int i = 0; i < numberRooms; i++) {
			rooms[i] = new Room();
		}
	}

	public List<Room> room;

	public void letEnter(Hero hero) {
		for (int i = 0; i < rooms.length; i++) {
			System.out.println(ANSI_RED + "!--- You are in the room " + (i + 1) + " with " + hero.getHealthPoints() + " health points ---!" + ANSI_RESET);
			rooms[i].enterRoom(hero);
			if (!hero.isAlive()) {
				System.out.println("Too bad you're dead");
				Game.gameOver();
				break;
			}
		}
		// Check if the hero has finished all rooms and is still alive
		if (hero.isAlive()) {
			System.out.println("Congratulations! You have completed all the rooms, you find treasure and won the game!");
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}
}