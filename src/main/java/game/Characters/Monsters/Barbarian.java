package game.Characters.Monsters;

import game.Characters.Character;
import game.Characters.Hero.Hero;
import game.Weapons.Axe;
import game.Weapons.WeaponType;
import java.util.Random;

public class Barbarian extends Monster {
    static final private int MAX_LIFE = 40;
    private static final double CRITICAL_HIT_CHANCE = 0.30; // 30% chance
    private final Random random = new Random();
    private boolean isParalyzed = false; // Paralyze statu

    public Barbarian() {
        super(MAX_LIFE);
        currentWeapon = new Axe();
        weakness = WeaponType.SWORD;
    }

    @Override
    public void attack(Character target) {
        // Statu paralyz barb
        if (isParalyzed) {
            isParalyzed = false; // Para for 1 turn
            return;
        }

        int damage = currentWeapon.getWeaponDamage();

        // Check CC is true
        if (random.nextDouble() < CRITICAL_HIT_CHANCE) {
            damage *= 2;
            System.out.println("Critical hit! Barbarian deals " + damage + " damage!");
        } else {
            System.out.println("Barbarian deals " + damage + " damage!");
        }
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage); // Calls the parent method to reduce health
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

    @Override
    public void applyEffect() {
        if (random.nextDouble() < Hero.getCriticalHitChance()) {
             setParalyzed(true);
        }
    }
}





