package game.Characters;

import game.Weapons.Weapon;
import lombok.Getter;

public abstract class Character {
    @Getter
    protected int healthPoints;
    protected Weapon currentWeapon;
    protected String name;
    @Getter
    protected boolean alive = true;

    public Character(int initialhealthPoints) {
        this.healthPoints = initialhealthPoints;
    }

    // Check CC or not
    public void attack(Character target) {
        target.takeDamage(currentWeapon.getWeaponDamage());
        System.out.println(target.getClass().getSimpleName() + healthPoints);
    }

    public void takeDamage(int amount) {
        this.healthPoints -= amount;
        System.out.println("\u001B[31m" + this.getClass().getSimpleName() + " loses " + amount + " HP." + "\u001B[0m");
        System.out.println(this.getClass().getSimpleName() + " has " + healthPoints + " HP.");

        if (this.healthPoints < 1) {
            alive = false;
        }
    }

    public void setParalyzed(boolean b) {
        return ;
    }

}
