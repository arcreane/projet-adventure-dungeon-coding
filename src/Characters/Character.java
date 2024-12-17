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

    private String name;
    private boolean alive = true;

	public Character(int initialhealthPoints, String names){
		this.healthPoints = initialhealthPoints;
		this.name = names;
	}


    // Fonction pour déterminer si un coup est critique
    public boolean isCriticalHit() {
        int chance = random.nextInt(5) + 1;
        return chance == 1; // Critique si le nombre est 1
    }

    public void attack(Character target) {

        if (isCriticalHit()) {
            target.takeDamage(currentWeapon.getWeaponDamage() * 2);
            System.out.println("Critical hit!");
        } else {
            target.takeDamage(10);
            System.out.println("Normal hit.");

        }

    }
public void takeDamage(int amount){
		this.healthPoints -= amount;
		if(this.healthPoints < 1){
			alive = false;
		}
<<<<<<< HEAD
		else {
			System.out.println("Normal hit.");

			}
	}
}

=======
}
public boolean isAlive(){
		return alive;
}
}
>>>>>>> a18493e7458819fc03195c6c6d6864e5de9aeca2
