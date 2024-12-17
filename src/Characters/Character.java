package Characters;

import Weapons.Weapon;
import java.util.Random;
/**
 * 
 */
public class Character {
	public int healthPoints;
	public Weapon currentWeapon;

	private Random random = new Random();

	// Fonction pour déterminer si un coup est critique
	public boolean isCriticalHit() {
		int chance = random.nextInt(5) + 1;
		return chance == 1; // Critique si le nombre est 1
	}

	public void attack(Character character) {
		if (isCriticalHit()) {
			System.out.println("Critical hit!");
		}
		else {
			System.out.println("Normal hit.");

			}
	}
	}

}