package Characters.Monsters;

import Characters.Character;
import Characters.Hero.Hero;
import Characters.Monsters.Magician;
import Weapons.Sword;
import Weapons.WeaponType;


public class Monster extends Character {
	

	public Monster(WeaponType weapon) {
		Weapons.Sword Sword = new Sword();
	}


	public WeaponType weakness;

<<<<<<< HEAD
 public boolean Monster(Magician magician) {
	 	 if (Hero && Monster) {
			 if (Magician = True) {
				System.out.println("Take your bottle !");
				return true;
				else {
					System.out.println("Take your sword !");
				}
			}
	 }
 }
=======
    public Monster() {
		super(100, "monster");
    }


    public static Monster createRandomMonster() {
		// TODO implement here
		return null;
	}


	public void attack() {
		// TODO implement here
	}

>>>>>>> a18493e7458819fc03195c6c6d6864e5de9aeca2
}