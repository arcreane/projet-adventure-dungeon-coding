package game.Characters.Monsters;

import java.util.Random;

public class MonsterGenerator {
    public static Monster RandomMonster() {
        MonsterType[] monsterTypes = MonsterType.values();
        Random random = new Random();
        return monsterTypes[random.nextInt(monsterTypes.length)].createMonster();
    }
}
