package game.Weapons;
// This line imports the @Data, @NoArgsConstructor, and @AllArgsConstructor annotations from the Lombok library
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// The @Data annotation is applied to the Weapon class
@Data

// This constructor creates a Weapon object with no arguments (default constructor)
@NoArgsConstructor
// This constructor creates a Weapon object with an initial weaponDamage value
@AllArgsConstructor
public class Weapon {
	// This variable stores the damage inflicted by the weapon
	protected int weaponDamage;

}