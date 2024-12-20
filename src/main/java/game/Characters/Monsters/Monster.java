package game.Characters.Monsters;

import game.Characters.Character;
import game.Weapons.WeaponType;
import java.util.Random;

/**
 * Abstract base class for all monster types in the game.
 * Extends the Character class and adds monster-specific functionality.
 */

public abstract class Monster extends Character {
	// Random number generator for critical hit calculations
	protected Random random = new Random();

	// Represents the type of weapon that this monster is weak against
	public WeaponType weakness;

	/**
	 * Constructor that initializes a monster with a maximum possible health value
	 * @param p_iMaxPossibleHealth The maximum health points the monster can have
	 */

	public Monster(int p_iMaxPossibleHealth) {
		super( p_iMaxPossibleHealth);
	}
	/**
	 * Determines if the current attack is a critical hit
	 * Returns true with a 20% chance (1 in 5)
	 * @return boolean True if the attack is critical, false otherwise
	 */
	public boolean isCriticalHit() {
		int chance = random.nextInt(5) + 1;
		return chance == 1; // Critical if the number is 1
	}
	/**
	 * Overrides the base attack method to implement critical hit mechanics
	 * If a critical hit occurs, applies a special effect instead of normal damage
	 * @param target The character being attacked
	 */
	@Override
	public void attack(Character target) {
		if (isCriticalHit()) {
			System.out.println("Critical hit!");
			applyEffect();
		} else {
			super.attack(target);
		}
	}
	/**
	 * Abstract method that defines the special effect applied on critical hits
	 * Must be implemented by concrete monster classes
	 */
	protected abstract void applyEffect();

	/**
	 * Returns a string representation of the monster's current health
	 * @return String representing the monster's health status
	 */
	protected String getHealth() {
        return "";
    }
}