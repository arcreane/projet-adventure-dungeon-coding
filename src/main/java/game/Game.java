package game;

import game.Characters.Hero.Hero;
import game.Dungeon.Dungeon;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Scanner;


public class Game implements PropertyChangeListener {
    public static Scanner sc = new Scanner(System.in);
    public static Dungeon dungeon;
    public static Hero hero;

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    private void startGame() {
        System.out.println("Select difficulty : \n\t- type 1 for easy (5 rooms)\n\t- type 2 for medium (10 rooms)\n\t- type 3 for hard (15 rooms)");
        //get the user input and make a switch in a while so that you have
        //a coherent answer
        // game.Dungeon initialization (parameters number of rooms)
        dungeon = new Dungeon(5);
        // Hero initialization
        hero = new Hero("Jenna la Guerrière");
        hero.subscribe("isAlive", this);
        hero.subscribe("isAlive", dungeon);
        hero.takeDamage(1000);
        System.out.println("Welcome to the game.Dungeon !");
        System.out.println("Are you ready to DIE ?");

       // dungeon.letEnter(hero);
    }

    public void death() {
        // TODO implement here
    }

    public void gameOver() {
        // TODO implement here
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        for(var field: hero.getClass().getDeclaredFields())
        {
            System.out.println(field.getName());
            if(field.getName().equals(evt.getPropertyName()))
                System.out.println("Do something");
        }

        if(Hero.Fields.isAlive.equals(evt.getPropertyName()))
        {
            System.out.println("that is also impacted");
        }
        System.out.println("Game : " + evt);
    }
}