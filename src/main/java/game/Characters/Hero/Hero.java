package game.Characters.Hero;

import game.Characters.Character;
import game.Characters.Monsters.Monster;
import game.Game;
import game.Weapons.Sword;
import game.Weapons.WaterFlask;
import game.Weapons.Weapon;
import game.Weapons.WeaponType;
import lombok.experimental.FieldNameConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
/**
 * The Hero class represents a playable character in the game.
 * It extends the `Character` class and adds specialized functionality, such as managing an arsenal of weapons and reacting to events.
 */

@FieldNameConstants() // Lombok annotation to generate constants for field names.
public class Hero extends Character {
    private Weapon currentWeapon; // The weapon currently equipped by the hero.
    private HashMap<WeaponType, Weapon> arsenal; // A collection of the hero's available weapons.
    private String m_sName; // The hero's name.
    private Boolean isAlive; // Tracks whether the hero is alive.
    private PropertyChangeSupport m_PCS = new PropertyChangeSupport(this);

    /**
     * Constructor for creating a hero with a default initial health of 1000.
     *
     * @param p_sName The name of the hero.
     */
    public Hero(String p_sName) {
        this(1000, p_sName);
    }
    /**
     * Constructor for creating a hero with a custom initial health.
     *
     * @param initialhealthPoints The starting health points for the hero.
     * @param p_sName             The name of the hero.
     */

    public Hero(int initialhealthPoints, String p_sName) {
        super(initialhealthPoints);
        m_sName = p_sName;

        // Initializes the hero's arsenal with a sword and a water flask.
        arsenal = new HashMap<WeaponType, Weapon>() {
            {
                put(WeaponType.WATER_FLASK, new WaterFlask());
                put(WeaponType.SWORD, new Sword());
            }
        };
    }
    /**
     * Allows other classes to subscribe to changes in the hero's properties.
     *
     * @param p_sPropertyName The name of the property to observe.
     * @param p_PCL           The listener that will react to changes in the property.
     */

    public void subscribe(String p_sPropertyName, PropertyChangeListener p_PCL) {
        m_PCS.addPropertyChangeListener(p_sPropertyName, p_PCL);
    }
    /**
     * The hero attacks a target. The player must type the name of the weapon correctly to deal damage.
     *
     * @param target The character being attacked (usually a monster).
     */
    @Override
    public void attack(Character target) {
        // Cast the target to a Monster (assumes target is always a Monster).
        Monster monster = (Monster) target;
        // Get the name of the currently equipped weapon.
        String weaponName = currentWeapon.getClass().getSimpleName();
        // Prompt the player to type the weapon's name to attack the monster.
        System.out.println("Type " + weaponName + " to hit the monster");
        String weapon = Game.sc.nextLine();

        // If the input matches the weapon name, the attack is successful.
        if (weapon.equalsIgnoreCase(weaponName)) {
            int damage = currentWeapon.getWeaponDamage();
            monster.takeDamage(damage); // Inflict damage on the monster.
            System.out.println("You hit the monster with " + weaponName + " for " + damage + " damage!");

            // If the monster dies, notify the player.
            if (!monster.isAlive()) {
                System.out.println("The monster has been defeated!");
            }
        } else {
            // If the input is incorrect, the attack misses.
            System.out.println("Sorry, wrong typing. You missed!");
        }
    }
    /**
     * The hero analyzes the monster to determine its weakness and equips the corresponding weapon.
     *
     * @param monster The monster the hero is fighting.
     */
    public void findWeaknessInMonster(Monster monster) {
        currentWeapon = arsenal.get(monster.weakness);
    }
    // Equip the weapon corresponding to the monster's weakness.

    /**
     * The hero takes damage and triggers a property change event if their health drops below zero.
     *
     * @param amount The amount of damage the hero takes.
     */
    @Override
    public void takeDamage(int amount) { // Calls the parent class to reduce health.
        super.takeDamage(amount);

        // If the hero is still alive, notify listeners of the hero's state.
        if (isAlive()) {
            String test = Hero.Fields.isAlive.toString();  // Retrieves the constant field name for "isAlive".
            m_PCS.firePropertyChange(test, true, false); // Notify listeners that "isAlive" has changed.
        }
    }
}