package Characters.Monsters;


import Characters.Character;
import Weapons.WaterFlask;
import Weapons.Weapon;
import Weapons.WeaponType;

public class Magician extends Monster {

	public int paralysisChance = 0;

	public Magician() {
		WaterFlask Waterflask = new WaterFlask();
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
}