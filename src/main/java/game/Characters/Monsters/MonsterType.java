package game.Characters.Monsters;

public enum MonsterType {
    BARBARIAN, MAGICIAN;

    public Monster createMonster() {
//        return switch (this) {
//            case MAGICIAN -> new Magician();
//            case BARBARIAN -> new Barbarian();
//        };
        return  new Barbarian();
    }
}
