package Characters.Monsters;

import Characters.Character;
import Weapons.Sword;
import Weapons.WeaponType;


public class Monster extends Character {

	public Monster(WeaponType weapon) {
		Weapons.Sword Sword = new Sword();
	}


	public WeaponType weakness;

    public Monster() {
    }


    public static Monster createRandomMonster() {
		// TODO implement here
		return null;
	}


	public void attack() {
		// TODO implement here
	}

}