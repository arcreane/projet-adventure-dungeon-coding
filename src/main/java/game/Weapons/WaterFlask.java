package game.Weapons;

import lombok.Data;

@Data
public class WaterFlask extends Weapon {
	public WaterFlask() {
		setWeaponDamage(20);
	}
	public int baseAttackPoints;
	public int bonusPerUse;
	public int usageCount;
}