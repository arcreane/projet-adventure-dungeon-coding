package game.Weapons;

import lombok.Data;

/**
 * 
 */
@Data
public class Sword extends Weapon {

	public int headHitChance;
	public boolean tryHeadHit;
	/**
	 * Default constructor
	 */
	public Sword() {
		weaponDamage = 10;
	}

}