package game.Dungeon;

import game.Characters.Hero.Hero;
import game.Characters.Monsters.Magician;
import game.Characters.Monsters.Monster;
import game.Characters.Monsters.MonsterGenerator;
import game.Game;
import lombok.Setter;

public class Room {
	@Setter
	private Monster monster;
	public Room() {
		// Creating a random monster
		monster = MonsterGenerator.RandomMonster();
	}

	public void enterRoom(Hero hero) {
		hero.findWeaknessInMonster(monster);
		while (monster.isAlive() && hero.isAlive()){
			System.out.println("A " + monster.getClass().getSimpleName() + " attacks you.");
			monster.attack(hero);
				hero.attack(monster);
		}
	}
}