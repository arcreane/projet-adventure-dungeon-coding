package game.Weapons;

import lombok.Data;

/**
 * Represents a Lightning weapon in the game
 * Extends the base Weapon class
 * Uses Lombok @Data annotation to automatically generate getters, setters,
 * equals, hashCode and toString methods
 */

@Data
public class Lightning extends Weapon {
	/**
	 * Constructor that initializes a Lightning weapon with 5 damage points
	 * Uses the setter method inherited from the Weapon class
	 */
	public Lightning() {
		setWeaponDamage(5);
	}

}