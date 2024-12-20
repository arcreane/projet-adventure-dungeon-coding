package game.Weapons;

import lombok.Data;

@Data
public class WaterFlask extends Weapon {
	// This variable stores the base attack points of the WaterFlask

	// This constructor sets the base damage of the WaterFlask to 20
	public WaterFlask() {
		setWeaponDamage(20);
	}
	public int baseAttackPoints;
	// This variable stores the bonus damage that the WaterFlask gains per use
	public int bonusPerUse;
	// This variable stores the number of times the WaterFlask has been used
	public int usageCount;
}