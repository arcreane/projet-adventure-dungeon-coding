package game.Characters.Monsters;

import game.Characters.Character;
import game.Weapons.Axe;
import game.Weapons.WeaponType;
import java.util.Random;
/**
 * The Barbarian class represents a monster with moderate health and the ability to perform critical hits during combat.
 * It extends the Monster class, inheriting basic functionality while adding its own unique behavior.
 */
public class Barbarian extends Monster {
    static final private int MAX_LIFE = 40; // The maximum health of the Barbarian.
    private static final double CRITICAL_HIT_CHANCE = 0.30; // Probability (30%) of performing a critical hit.
    private final Random random = new Random(); // Random generator for determining critical hits.

    /**
     * Constructor for the Barbarian class.
     * Initializes the Barbarian with maximum health, an Axe as its weapon, and a weakness to Swords.
     */
    public Barbarian() {
        super(MAX_LIFE); // Initializes the monster with the specified maximum health.
        currentWeapon = new Axe(); // Assigns an Axe as the Barbarian's weapon.
        weakness = WeaponType.SWORD; // Sets the Barbarian's weakness to swords.
    }
    /**
     * Executes an attack on a target character.
     * The Barbarian has a chance to perform a critical hit, which doubles the damage dealt.
     *
     * @param target The character being attacked by the Barbarian.
     */
    @Override
    public void attack(Character target) {
        int damage = currentWeapon.getWeaponDamage();// Retrieves the damage value of the equipped weapon.

        // Check if a critical hit occurs based on a random chance.
        if (random.nextDouble() < CRITICAL_HIT_CHANCE) {
            damage *= 2; // Double the damage for a critical hit.
            System.out.println("Critical hit! Barbarian deals " + damage + " damage!");
        } else {
            System.out.println("Barbarian deals " + damage + " damage!");
        }
        // Inflict damage on the target character.
        target.takeDamage(damage); // Inflige les dégâts à la cible
    }
    /**
     * Reduces the Barbarian's health points when taking damage.
     * This method overrides the base class implementation but does not add custom behavior for now.
     *
     * @param damage The amount of damage to inflict on the Barbarian.
     */
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage); // Calls the parent class method to reduce health points.
        // You can uncomment the line below to log the remaining health if needed.
        //System.out.println("Barbarian takes " + damage + " damage! Remaining health: " + this.getHealth());
    }
    /**
     * Applies any special effects specific to the Barbarian.
     * Currently, this method does nothing, but it is available for future expansion.
     */
    @Override
    protected void applyEffect() {
        // Aucun effet spécifique pour l'instant
    }
}





//package game.Characters.Monsters;
//
//import game.Characters.Character;
//import game.Weapons.Axe;
//import game.Weapons.WeaponType;
//
//public class Barbarian extends Monster  {
//	static final private int  MAX_LIFE = 40;
//    private static final double CRITICAL_HIT_CHANCE = 0.30; //30% chance
//    //public int criticalChance;
//
//	public Barbarian() {
//		super(MAX_LIFE);
//        currentWeapon = new Axe();
//		weakness = WeaponType.SWORD;
//
//	}
//    @Override
//    public void attack(Character target) {
//        int damage = currentWeapon.getWeaponDamage();
//        // Vérifier si un coup critique se produit
//        if (random.nextDouble() < CRITICAL_HIT_CHANCE) {
//            damage *= 2; // Coup critique, double des dégâts
//            System.out.println("Critical hit! Barbarian deals " + damage + " damage!");
//        } else {
//            System.out.println("Barbarian deals " + damage + " damage!");
//        }
//	}
//
//    @Override
//    protected void applyEffect() {
//    }
//}
