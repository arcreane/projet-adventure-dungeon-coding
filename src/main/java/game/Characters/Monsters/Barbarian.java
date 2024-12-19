package game.Characters.Monsters;

import game.Weapons.Axe;
import game.Weapons.WeaponType;

public class Barbarian extends Monster  {
	static final private int  MAX_LIFE = 0;
	public int criticalChance;

	public Barbarian() {
		super(MAX_LIFE);
        currentWeapon = new Axe();
		weakness = WeaponType.SWORD;

	}

	@Override
	protected void applyEffect() {

	}


}