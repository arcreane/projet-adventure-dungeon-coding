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

    // Fonction pour déterminer si un coup est critique
    public void attack(Character target) {
        target.takeDamage(currentWeapon.getWeaponDamage());
        System.out.println(target.getClass().getSimpleName() + healthPoints);
    }

    public void takeDamage(int amount) {
        this.healthPoints -= amount;
        System.out.println( this.getClass().getSimpleName()  +" loses " + amount + " HP.");
        System.out.println(this.getClass().getSimpleName()  +" have " + healthPoints + " HP.");
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
    public void setParalyzed(boolean b) {
        return ;
    }

}
