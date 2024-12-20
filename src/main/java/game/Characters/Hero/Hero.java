package game.Characters.Hero;

import game.Characters.Character;
import game.Characters.Monsters.Barbarian;
import game.Characters.Monsters.Monster;
import game.Game;
import game.Weapons.Sword;
import game.Weapons.WaterFlask;
import game.Weapons.Weapon;
import game.Weapons.WeaponType;
import lombok.experimental.FieldNameConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Random;

@FieldNameConstants()
public class Hero extends Character {
    private Weapon currentWeapon;
    private HashMap<WeaponType, Weapon> arsenal;
    private String m_sName;
    private Boolean isAlive;
    private static final double CRITICAL_HIT_CHANCE = 100; // 0.10% chance
    private final Random random = new Random();
    private boolean isParalyzed = false;
    private PropertyChangeSupport m_PCS = new PropertyChangeSupport(this);

    public Hero(String p_sName) {
        this(100, p_sName);
    }

    public Hero(int initialHealthPoints, String p_sName) {
        super(initialHealthPoints);
        m_sName = p_sName;
        arsenal = new HashMap<WeaponType, Weapon>() {
            {
                put(WeaponType.WATER_FLASK, new WaterFlask());
                put(WeaponType.SWORD, new Sword());
            }
        };
    }

    public void subscribe(String p_sPropertyName, PropertyChangeListener p_PCL) {
        m_PCS.addPropertyChangeListener(p_sPropertyName, p_PCL);
    }

    @Override
    public void attack(Character target) {
        if (isParalyzed) {
            System.out.println(m_sName + " is paralyzed and cannot attack this turn!");
            isParalyzed = false; // Paralysis wears off after one turn
            return;
        }

        if (!(target instanceof Monster)) {
            System.out.println("The target is not a monster!");
            return;
        }

        Monster monster = (Monster) target;
        String weaponName = currentWeapon.getClass().getSimpleName();
        System.out.println("Type " + weaponName + " to hit the monster");
        String weapon = Game.sc.nextLine();
        if (weapon.equalsIgnoreCase(weaponName)) {
            int damage = currentWeapon.getWeaponDamage();
            // Check if the target is a Barbarian and if the critical hit chance applies
            if (monster instanceof Barbarian && random.nextDouble() < CRITICAL_HIT_CHANCE) {
                ((Barbarian) monster).setParalyzed(true); // Apply paralysis to the Barbarian
            }
            monster.takeDamage(damage);
            System.out.println("You hit the monster with " + weaponName + " for " + damage + " damage!");
            if (!monster.isAlive()) {
                System.out.println("The monster has been defeated!");
            }
        } else {
            System.out.println("Sorry, wrong typing. You missed!");
        }
    }

    public void findWeaknessInMonster(Monster monster) {
        currentWeapon = arsenal.get(monster.weakness);
    }

    @Override
    public void takeDamage(int amount) {
        super.takeDamage(amount);
        if (isAlive()) {
            String test = Hero.Fields.isAlive.toString();
            m_PCS.firePropertyChange(test, true, false);
        }
    }

    public void setParalyzed(boolean paralyzed) {
        isParalyzed = paralyzed;
        if (paralyzed) {
            System.out.println(m_sName + " is paralyzed and cannot attack next turn!");
        }
    }
}

