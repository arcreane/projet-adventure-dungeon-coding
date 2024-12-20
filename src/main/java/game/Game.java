package game;

import game.Characters.Hero.Hero;
import game.Dungeon.Dungeon;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Scanner;


public class Game implements PropertyChangeListener {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    private void startGame() {
//        System.out.println("Select difficulty : \n\t- type 1 for easy (5 rooms)\n\t- type 2 for medium (10 rooms)\n\t- type 3 for hard (15 rooms)");
//        String answer = sc.nextLine().toLowerCase();
//        switch (answer) {
//            case "1": 5 rooms; break;
//            case "2": 10 rooms; break;
//            case "3": 15 rooms; break;
//            default: System.out.println("Invalid input");
        //get the user input and make a switch in a while so that you have
        //a coherent answer
        // game.Dungeon initialization (parameters number of rooms)
        Dungeon dungeon = new Dungeon(5);
        // Hero initialization
        Hero hero = new Hero("Jenna the Warrior");
        hero.subscribe("isAlive", this);
        hero.subscribe("isAlive", dungeon);
        System.out.println("Welcome to the Dungeon !");
        System.out.println("Are you ready to DIE ?");

        dungeon.letEnter(hero);
    }

    public void gameOver() {
        System.out.println("Game Over");
        String answer = "";
        do {
            System.out.println("Do you want to play again? Y or N ?");
            answer = sc.nextLine().toLowerCase();
        } while (!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")));
        switch (answer) {
            case "y":
                startGame();
                break;
            case "n":
                System.exit(0);
            default:
                System.out.println("Bad answer.");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!Hero.Fields.isAlive.equals(evt.getPropertyName())) {
            gameOver();
        }

    }
}