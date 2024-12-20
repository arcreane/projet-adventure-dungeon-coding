package game.Characters.Monsters;

import java.util.Random;
/**
 * Utility class that generates random monsters for the game
 */
public class MonsterGenerator {
    /**
     * Static method that creates and returns a random monster
     * Randomly selects a monster type from the available MonsterType enum values
     *
     * @return Monster A new randomly generated monster instance
     */
    public static Monster RandomMonster() {
        // Get all possible monster types from the enum
        MonsterType[] monsterTypes = MonsterType.values();
        // Create random number generator
        Random random = new Random();
        // Generate a random monster by:
        // 1. Selecting a random index within the monster types array
        // 2. Getting the monster type at that index
        // 3. Creating a new monster of that type
        return monsterTypes[random.nextInt(monsterTypes.length)].createMonster();
    }
}
