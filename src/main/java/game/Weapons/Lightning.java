package game.Weapons;

import lombok.Data;

@Data
public class Lightning extends Weapon {
	public Lightning() {
		setWeaponDamage(5);
	}

}