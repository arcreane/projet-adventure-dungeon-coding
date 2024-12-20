package game.Characters.Monsters;


import game.Characters.Character;
import game.Weapons.Lightning;
import game.Weapons.WeaponType;
import java.util.Random;
import game.Characters.Hero.*;

public class Magician extends Monster {
	private int flaskCount;
	private int flaskDmgBonus;
	private static final double PARALYSIS_CHANCE = 0.10; // 10% chance
	private final Random random = new Random();
	//public int paralysisChance = 0;

	public Magician() {
		super(40); // Points de vie du magicien
		this.currentWeapon = new Lightning(); // Arme éclair
		weakness = WeaponType.WATER_FLASK;
		this.flaskCount = 0;
		this.flaskDmgBonus = 0;
	}

	public void flaskThrow(Hero damage) {
		this.flaskDmgBonus = this.flaskCount * 2;
		this.flaskCount++;
		System.out.println("Flask Throw ! Bonus damage " + this.flaskDmgBonus + " points.");
	}

	@Override
	public void attack(Character target) {
		// Attaque normale avec l'éclair
		int damage = currentWeapon.getWeaponDamage();
		System.out.println("Magician cast lightnings bolt " + damage + " damages !");
		target.takeDamage(damage);
		//System.out.println("Magician status:" +(healthPoints));
		//this.displayHealthStatus(target);

		// Tentative de paralysie uniquement si la cible est un héros
		if (target instanceof Hero && random.nextDouble() < PARALYSIS_CHANCE) {
			target.setParalyzed(true);
			System.out.println("The hero is paralyzed for the next turn!");
		}
	}
	@Override
	protected void applyEffect() {
	}
}