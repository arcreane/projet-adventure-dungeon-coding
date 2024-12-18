package game.Characters.Monsters;


import game.Characters.Character;
import game.Weapons.Lightning;
import game.Weapons.WaterFlask;
import game.Weapons.WeaponType;

public class Magician extends Monster {

	public int paralysisChance = 0;

	public Magician() {
		super(10);
		currentWeapon = new Lightning();
		weakness = WeaponType.WATER_FLASK;
	}



	@Override
	public void attack(Character target) {

		if (isCriticalHit()) {
			target.takeDamage(currentWeapon.getWeaponDamage() * 2);
			System.out.println("Critical hit!");
		} else {
			target.takeDamage(10);
			System.out.println("Normal hit.");

		}


	}

	@Override
	protected void applyEffect() {

	}
}