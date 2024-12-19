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
    Weapon currentWeapon;
    HashMap<WeaponType, Weapon> arsenal;
    String m_sName;

    Boolean isAlive;


    PropertyChangeSupport m_PCS = new PropertyChangeSupport(this);

    public Hero(String p_sName) {
        this(50, p_sName);
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

        String weaponName = currentWeapon.getClass().getSimpleName();
        System.out.println("Type " + weaponName + " to hit the monster");
        String weapon = Game.sc.nextLine();
        if (weapon.equals(weaponName)) {
            System.out.println("You hit the monster");
            takeDamage(10);

        } else {
            System.out.println("Sorry, wrong typing you missed");
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




    /*
	public void attack() {
		// TODO implement here
	}

	public void isAlive() {
		// TODO implement here
	}
*/
}