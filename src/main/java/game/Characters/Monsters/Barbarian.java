package game.Characters.Monsters;

import game.Characters.Character;
import game.Weapons.Axe;
import game.Weapons.WeaponType;
import java.util.Random;

public class Barbarian extends Monster {
    static final private int MAX_LIFE = 40; // Vie maximale du barbare
    private static final double CRITICAL_HIT_CHANCE = 0.30; // 30% chance
    private final Random random = new Random();

    public Barbarian() {
        super(MAX_LIFE);
        currentWeapon = new Axe();
        weakness = WeaponType.SWORD;
    }

    @Override
    public void attack(Character target) {
        int damage = currentWeapon.getWeaponDamage();
        // Vérifier si un coup critique se produit
        if (random.nextDouble() < CRITICAL_HIT_CHANCE) {
            damage *= 2; // Coup critique, double des dégâts
            System.out.println("Critical hit! Barbarian deals " + damage + " damage!");
        } else {
            System.out.println("Barbarian deals " + damage + " damage!");
        }

        target.takeDamage(damage); // Inflige les dégâts à la cible
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage); // Appelle la méthode parente pour réduire les points de vie
        System.out.println("Barbarian takes " + damage + " damage! Remaining health: " + this.getHealth());
    }

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
