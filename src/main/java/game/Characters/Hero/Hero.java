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

@FieldNameConstants()
public class Hero extends Character {
    private Weapon currentWeapon;
    private HashMap<WeaponType, Weapon> arsenal;
    private String m_sName;
    private Boolean isAlive;
    private PropertyChangeSupport m_PCS = new PropertyChangeSupport(this);

    public Hero(String p_sName) {
        this(1000, p_sName);
    }

    public Hero(int initialhealthPoints, String p_sName) {
        super(initialhealthPoints);
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
        Monster monster = (Monster) target;
        String weaponName = currentWeapon.getClass().getSimpleName();
        System.out.println("Type " + weaponName + " to hit the monster");
        String weapon = Game.sc.nextLine();
        if (weapon.equalsIgnoreCase(weaponName)) {
            int damage = currentWeapon.getWeaponDamage();
            monster.takeDamage(damage); // Inflige les dégâts au monstre
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
}