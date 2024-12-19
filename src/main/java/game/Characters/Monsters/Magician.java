package game.Characters.Monsters;


import game.Characters.Character;
import game.Weapons.Lightning;
import game.Weapons.WaterFlask;
import game.Weapons.WeaponType;
import java.util.Random;
import game.Characters.Hero.*;

import java.util.Random;

public class Magician extends Monster {
	private static final double PARALYSIS_CHANCE = 0.10; // 10% chance
	private final Random random = new Random();
	public int paralysisChance = 0;

	public Magician() {
		super(40); // Points de vie du magicien
		this.currentWeapon = new Lightning(); // Arme éclair
		weakness = WeaponType.WATER_FLASK;
	}

	@Override
	public void attack(Character target) {
		// Attaque normale avec l'éclair
		int damage = currentWeapon.getWeaponDamage();
		target.takeDamage(damage);
		System.out.println("Magician cast lightnings bolt " + damage + " damages !");
		System.out.println("Magician status:");
		this.displayHealthStatus(target);

		// Tentative de paralysie uniquement si la cible est un héros

		if (target instanceof Hero && random.nextDouble() < PARALYSIS_CHANCE) {

			target.setParalyzed(true);
			System.out.println("Le héros est paralysé pour le prochain tour !");
		}
	}





	/*@Override
	public void attack(Character target) {

		if (isCriticalHit()) {
			target.takeDamage(currentWeapon.getWeaponDamage() * 2);
			System.out.println("Critical hit!");
		} else {
			target.takeDamage(10);
			System.out.println("Normal hit.");

		}


	}
*/
	@Override
	protected void applyEffect() {

	}
}