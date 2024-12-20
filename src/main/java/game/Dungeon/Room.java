package game.Dungeon;

import game.Characters.Hero.Hero;
import game.Characters.Monsters.Magician;
import game.Characters.Monsters.Monster;
import game.Characters.Monsters.MonsterGenerator;
import game.Game;
import lombok.Setter;

/**
 * The Room class represents a single room in the dungeon.
 * Each room contains a monster, which the hero must confront upon entering.
 */
public class Room {
	@Setter
	private Monster monster; // The monster inhabiting this room, which can be set using a setter.
	/**
	 * Default constructor for a Room.
	 * A random monster is generated for the room when it is created.
	 */
	public Room() {
		// Generate a random monster for this room using MonsterGenerator.
		monster = MonsterGenerator.RandomMonster();
	}
	/**
	 * Simulates the hero entering the room and battling the monster inside.
	 * The hero and the monster take turns attacking until one of them dies.
	 *
	 * @param hero The hero entering the room to fight the monster.
	 */

	public void enterRoom(Hero hero) {
		// The hero tries to find the monster's weakness before engaging in combat.
		hero.findWeaknessInMonster(monster);

		// Battle loop: continues until either the hero or the monster is dead.
		while (monster.isAlive() && hero.isAlive()){
			// Monster attacks the hero.
			System.out.println("A " + monster.getClass().getSimpleName() + " attacks you.");
			monster.attack(hero);

//			if(hero.isKo()){
//				System.out.println("You are knocked out you pass your turn");
//				hero.setKo(false);
//			}else{
				hero.attack(monster);
//			}
		}
	}
}