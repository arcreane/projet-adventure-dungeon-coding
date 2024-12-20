package game.Dungeon;

import game.Characters.Hero.Hero;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class Dungeon implements PropertyChangeListener {
    private final Room[] rooms;

	public Dungeon(int numberRooms) {
		// Initialization of rooms with their monster
        rooms = new Room[numberRooms];
		for(int i = 0; i < numberRooms; i++){
			rooms[i] = new Room();
		}
	}
	public List<Room> room;

    public void letEnter(Hero hero) {
		//System.out.println("-- game.Dungeon Monster --\n");
		for(int i = 0 ; i < rooms.length ; i ++){
			System.out.println("You are in the room " + (i + 1) + " with "+ hero.getHealthPoints()+ " health points");
			rooms[i].enterRoom(hero);
			if(!hero.isAlive()) {
				System.out.println("Too bad you're dead");
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