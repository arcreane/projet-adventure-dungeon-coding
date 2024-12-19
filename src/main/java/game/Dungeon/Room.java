package game.Dungeon;

import game.Characters.Hero.Hero;
import game.Characters.Monsters.Monster;
import game.Characters.Monsters.MonsterGenerator;
import game.Game;
/**
 * 
 */
public class Room {

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


//			if(hero.isKo()){
//				System.out.println("You are knocked out you pass your turn");
//				hero.setKo(false);
//			}else{
				hero.attack(monster);
//			}
		}
	}

}