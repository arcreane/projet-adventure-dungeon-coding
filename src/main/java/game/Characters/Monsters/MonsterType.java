package game.Characters.Monsters;
/**
 * Enum representing the different types of monsters available in the game
 * Provides a factory method to create monster instances
 */
public enum MonsterType {
    BARBARIAN, MAGICIAN;  // Available monster types

    /**
     * Factory method that creates and returns a new monster instance
     * based on the enum type
     *
     * @return Monster A new instance of the specific monster type
     */
    public Monster createMonster() {
        return switch (this) {
            case MAGICIAN -> new Magician();
            case BARBARIAN -> new Barbarian();
        };
    }
}
