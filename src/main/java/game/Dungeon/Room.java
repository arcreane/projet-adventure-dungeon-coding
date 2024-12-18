package game.Dungeon;

import game.Characters.Hero.Hero;
import game.Characters.Monsters.Monster;
import game.Characters.Monsters.MonsterGenerator;

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
		hero.findWeaknessInMonster(monster);
		while (monster.isDead() && hero.isDead()){
			System.out.println("A " + monster.getClass().getName() + " attacks you.");
			monster.attack(hero);

//			if(hero.isKo()){
//				System.out.println("You are knocked out you pass your turn");
//				hero.setKo(false);
//			}else{
//				hero.attack(monster);
//			}
		}
	}

}