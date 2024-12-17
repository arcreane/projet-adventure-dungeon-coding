package Dungeon;

import Characters.Monsters.Barbarian;

import java.util.*;

public class Dungeon {
	public static int Room;
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


	public void endCombat() {
		// TODO implement here
	}


	public void goTonextroom() {
		// TODO implement here
	}

}