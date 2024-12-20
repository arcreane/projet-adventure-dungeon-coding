package game.Characters.Monsters;

import game.Characters.Character;
import game.Weapons.Axe;
import game.Weapons.WeaponType;
import java.util.Random;

public class Barbarian extends Monster {
    static final private int MAX_LIFE = 40; // Vie maximale du barbare
    private static final double CRITICAL_HIT_CHANCE = 0.30; // 30% chance
    private final Random random = new Random();
    private boolean isParalyzed = false; // État de paralysie du barbare

    public Barbarian() {
        super(MAX_LIFE);
        currentWeapon = new Axe();
        weakness = WeaponType.SWORD;
    }

    @Override
    public void attack(Character target) {
        // Vérifier si le barbare est paralysé
        if (isParalyzed) {
            isParalyzed = false; // La paralysie disparaît après un tour
            return;
        }

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
        //System.out.println("Barbarian takes " + damage + " damage! Remaining health: " + this.getHealth());
    }

    public void setParalyzed(boolean paralyzed) {
        isParalyzed = paralyzed;
        if (paralyzed) {
            System.out.println("Barbarian is now paralyzed and will skip their next turn!");
        }
    }

    public boolean isParalyzed() {
        return isParalyzed;
    }
}






