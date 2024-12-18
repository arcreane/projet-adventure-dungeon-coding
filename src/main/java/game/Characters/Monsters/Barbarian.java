package game.Characters.Monsters;

import game.Weapons.Sword;

public class Barbarian extends Monster  {
	static final private int  MAX_LIFE = 10;
	public int criticalChance;

	public Barbarian() {
		super(MAX_LIFE);
        game.Weapons.Sword Sword = new Sword();
	}

	@Override
	protected void applyEffect() {

	}


}