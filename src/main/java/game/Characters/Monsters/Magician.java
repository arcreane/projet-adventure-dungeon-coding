package game.Characters.Monsters;


import game.Characters.Character;
import game.Weapons.Lightning;
import game.Weapons.WeaponType;
import java.util.Random;
import game.Characters.Hero.*;
/**
 * Represents a Magician monster type that can cast lightning attacks and paralyze heroes
 * Extends the base Monster class
 */
public class Magician extends Monster {
	private static final double PARALYSIS_CHANCE = 0.10; // Constant defining the 10% chance of paralyzing the target
	private final Random random = new Random(); // Random number generator for paralysis chance calculations

	/**
	 * Constructor that initializes a Magician with:
	 * - 40 health points
	 * - Lightning as default weapon
	 * - Weakness to water flask weapons
	 */

	public Magician() {
		super(40); // Magician's health points
		this.currentWeapon = new Lightning(); // Lightning weapon
		weakness = WeaponType.WATER_FLASK;
	}

	/**
	 * Overrides the attack method to implement Magician's specific attack behavior:
	 * - Deals lightning damage to the target
	 * - Has a chance to paralyze if the target is a Hero
	 *
	 * @param target The character being attacked
	 */
	@Override
	public void attack(Character target) {
		// Normal lightning attack
		int damage = currentWeapon.getWeaponDamage();
		System.out.println("Magician cast lightnings bolt " + damage + " damages !");
		target.takeDamage(damage);
		//System.out.println("Magician status:" +(healthPoints));
		//this.displayHealthStatus(target);

		// Attempt to paralyze only if target is a hero
		if (target instanceof Hero && random.nextDouble() < PARALYSIS_CHANCE) {
			target.setParalyzed(true);
			System.out.println("The hero is paralyzed for the next turn!");
		}
	}
	/**
	 * Implements the abstract applyEffect method from Monster class
	 * Currently empty as the Magician's special effects are handled in attack()
	 */
	@Override
	protected void applyEffect() {
	}
}