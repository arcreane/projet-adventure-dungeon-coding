package game.Weapons;

import lombok.Data;

/**
 * Represents a Sword weapon in the game
 * Extends the base Weapon class
 * Uses Lombok @Data annotation to automatically generate getters, setters,
 * equals, hashCode and toString methods
 */

@Data
public class Sword extends Weapon {

	// Chance percentage to hit the head with the sword
	public int headHitChance;

	// Flag indicating if a head hit was attempted
	public boolean tryHeadHit;

	/**
	 * Constructor that initializes a Sword with 100 damage points
	 */
	public Sword() {
		weaponDamage = 15;
	}

}