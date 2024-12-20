package game.Weapons;

import lombok.Data;
/**
 * Represents an Axe weapon in the game
 * Extends the base Weapon class
 * Uses Lombok @Data annotation to automatically generate getters, setters,
 * equals, hashCode and toString methods
 */

@Data
public class Axe extends Weapon {
    /**
     * Constructor that initializes an Axe with 10 damage points
     */
    public Axe() {weaponDamage = 10;}
}
