package game.Dungeon;

import game.Characters.Hero.Hero;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class Dungeon implements PropertyChangeListener {
    private Room[] rooms;

	public Dungeon(int numberRooms) {
		// Initialization of rooms with their monster
        rooms = new Room[numberRooms];
		for(int i = 0; i < numberRooms; i++){
			rooms[i] = new Room();
		}
	}

	public List<Room> room;


	public int currentRoomIndex;


	public void death() {
		// TODO implement here
	}

	public void endCombat() {
		// TODO implement here
	}


	public void goTonextroom() {
		// TODO implement here
	}

    public void letEnter(Hero hero) {

		System.out.println("-- game.Dungeon Monster --\n");
		for(int i = 0 ; i < rooms.length ; i ++){
			System.out.println("You are in the room n°" + (i + 1));
			rooms[i].enterRoom(hero);
			if(!hero.isAlive())
				System.out.println("Too bad you're dead");
			  break;
		}
    }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Dungeon : " + evt);
	}
}