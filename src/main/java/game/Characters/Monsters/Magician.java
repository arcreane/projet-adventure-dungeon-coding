package game.Characters.Monsters;

import game.Characters.Character;
import game.Characters.Hero.Hero;
import game.Weapons.Lightning;
import game.Weapons.WeaponType;
import java.util.Random;

public class Magician extends Monster {
	private static final double PARALYSIS_CHANCE = 0.10; // 10% chance
	private final Random random = new Random();
	private int waterFlaskCount; // Flask number hit
	private int additionalDamage; // Increase Damage

	public Magician() {
		super(40);
		this.currentWeapon = new Lightning();
		weakness = WeaponType.WATER_FLASK; // Weapon for Hero
		this.waterFlaskCount = 0;
		this.additionalDamage = 0;
	}

	@Override
	public void takeDamage(int damage) {
		// Stack FlaskDamage
		int totalDamage = damage + additionalDamage;
		super.takeDamage(totalDamage);
		System.out.println("Magician takes " + totalDamage + " damage! (Base damage: " + damage +
				", Additional damage from water flasks: " + additionalDamage + ")");
	}

	public void receiveWaterFlask() { //Count WaterFlask
		waterFlaskCount++;
		if (waterFlaskCount > 5) {
			waterFlaskCount = 0;
		}
		additionalDamage = waterFlaskCount * 2; // Each WaterFlask up damage per 2
		System.out.println("Magician receives a water flask! Total flasks: " + waterFlaskCount +
				", Additional damage now increased by " + additionalDamage);
	}

	@Override
	public void attack(Character target) {
		int damage = currentWeapon.getWeaponDamage();
		System.out.println("Magician casts a lightning bolt dealing " + damage + " damage!");
		target.takeDamage(damage);
		// Paralysis attempt only if target is a hero
		if (target instanceof Hero && random.nextDouble() < PARALYSIS_CHANCE) {
			target.setParalyzed(true);
			System.out.println("The hero is paralyzed for the next turn!");
		}
	}
	@Override
	public void applyEffect() {
		receiveWaterFlask();
	}
}