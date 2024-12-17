package Characters.Hero;

import Characters.Character;
import Weapons.Sword;
import Weapons.WaterFlask;
import Weapons.Weapon;

import java.util.*;

public class Hero extends Character {

	public Hero(){
		super(100, "jenna");
	}

	String name;
	Weapon currentWeapon;

	public void selectWeapon() {
		Scanner sc = new Scanner(System.in);
		boolean validWeapon = false;

		while (!validWeapon) { // Boucle tant que l'utilisateur n'entre pas une arme valide
			System.out.println("Which weapon do you want? ");
			String weapon = sc.nextLine();

			switch (weapon.toLowerCase()) {
				case "sword":
					currentWeapon = new Sword();
					validWeapon = true;
					System.out.println("You selected the Sword!");
					break;
				case "waterflask":
					currentWeapon = new WaterFlask();
					validWeapon = true;
					System.out.println("You selected the Water Flask!");
					break;
				default:
					System.out.println("Wrong weapon, try again!");
			}
			sc.close(); // Fermer le Scanner après utilisation
		}

	}

/*
	public void attack() {
		// TODO implement here
	}

	public void isAlive() {
		// TODO implement here
	}
*/
}