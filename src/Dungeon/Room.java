package Dungeon;

import Characters.Hero.Hero;
import Characters.Monsters.Monster;
import Characters.Monsters.MonsterGenerator;
import Characters.Monsters.MonsterType;

import java.util.Random;

/**
 * 
 */
public class Room {

	private Monster monster;

	public Room() {
		// Creating a random monster
		monster = MonsterGenerator.RandomMonster();

	}


	/**
	 * @param hero
	 */
	public void enterRoom(Hero hero) {
		// TODO implement here
	}

}