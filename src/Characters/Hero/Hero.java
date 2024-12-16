package Characters.Hero;

import Characters.Character;
import Weapons.Weapon;

import java.util.*;

/**
 * 
 */
public class Hero extends Character {

	String name;
	/**
	 * Default constructor
	 */
	public Hero() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the character: ");
		name = sc.nextLine();
	}

	/**
	 * 
	 */
	public List<Weapon> arsenal;

	public int selectWeapon() {
		System.out.println("Weapon is selected by " + name);
		return 2;
	}

	/**
	 * 
	 */
	public void attack() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void isAlive() {
		// TODO implement here
	}

}