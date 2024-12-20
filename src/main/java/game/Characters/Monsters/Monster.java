package game.Characters.Monsters;

import game.Characters.Character;
import game.Weapons.WeaponType;
import java.util.Random;


public abstract class Monster extends Character {
	protected Random random = new Random();

	public WeaponType weakness;

	public Monster(int p_iMaxPossibleHealth) {
		super( p_iMaxPossibleHealth);
	}

	public boolean isCriticalHit() {
		int chance = random.nextInt(5) + 1;
		return chance == 1; // Critique si le nombre est 1
	}

	protected abstract void applyEffect();

	protected String getHealth() {
        return "";
    }
}