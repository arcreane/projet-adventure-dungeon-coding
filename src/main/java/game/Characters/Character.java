package game.Characters;

import game.Weapons.Weapon;
import lombok.Getter;

/**
 * The Character class serves as an abstract base class for all characters in the game,
 * including heroes and monsters. It provides core functionality like health management,
 * attacking, and taking damage.
 */

public abstract class Character {
    @Getter
    protected int healthPoints; // The current health points of the character.
    protected Weapon currentWeapon; // The weapon the character is currently using.
    protected String name; // The name of the character.

    @Getter
    protected boolean alive = true; // Tracks whether the character is alive.

    /**
     * Constructor for initializing a character with a given amount of health points.
     *
     * @param initialhealthPoints The starting health points for the character.
     */
    public Character(int initialhealthPoints) {
        this.healthPoints = initialhealthPoints;
    }

    /**
     * Simulates an attack on a target character, dealing damage based on the weapon's damage value.
     *
     * @param target The character being attacked.
     */
    public void attack(Character target) {
        // Deals damage to the target based on the current weapon's damage value.
        target.takeDamage(currentWeapon.getWeaponDamage());
        // Displays the target's class name and current health points+ healthPoints);
    }
    /**
     * Reduces the character's health points when taking damage.
     * If health drops below 1, the character is marked as dead (`alive = false`).
     *
     * @param amount The amount of damage to inflict on the character.
     */
    public void takeDamage(int amount) {
        this.healthPoints -= amount; // Reduces health points by the damage amount.

        // Displays damage dealt and remaining health points.
        System.out.println( this.getClass().getSimpleName()  +" loses " + amount + " HP.");
        System.out.println(this.getClass().getSimpleName()  +" have " + healthPoints + " HP.");

        // Marks the character as dead if health drops below 1.
        if (this.healthPoints < 1) {
            alive = false;
        }
}
//
//    protected void displayHealthStatus(Character target){
//        //System.out.println("remaining life points :" + getHealthPoints());
//        target.takeDamage(currentWeapon.getWeaponDamage());
//        System.out.println(target.getClass().getSimpleName() + " a " + target.getHealthPoints() + " points de vie restants.");
//        target.displayHealthStatus(target);
//    }
    /**
     * Placeholder method for setting the "paralyzed" status of the character.
     * Currently not implemented.
     *
     * @param b A boolean value indicating whether the character is paralyzed.
     */
    public void setParalyzed(boolean b) {
    }

}
