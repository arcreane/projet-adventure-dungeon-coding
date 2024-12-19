package game.Characters;

import game.Weapons.Weapon;


public abstract class Character {
    public int healthPoints;
    public Weapon currentWeapon;


    private String name;
    private boolean alive = true;

    public Character(int initialhealthPoints) {
        this.healthPoints = initialhealthPoints;
    }


    // Fonction pour déterminer si un coup est critique

    public void attack(Character target) {
        target.takeDamage(currentWeapon.getWeaponDamage());
        System.out.println(target.getClass().getSimpleName() + healthPoints);
    }

    public void takeDamage(int amount) {
        this.healthPoints -= amount;
        if (this.healthPoints < 1) {
            alive = false;
        }
    }
    public void setParalyzed(boolean b) {
    }

    public boolean isAlive() {
        return alive;
    }
}
