import Characters.Hero.Hero;
import Dungeon.Dungeon;
import java.util.Scanner;


public class Game {
	public static Scanner sc = new Scanner(System.in);
	public static Dungeon dungeon;
	public static Hero hero;

	public static void main(String[] args) {
		// Dungeon initialization (parameters number of rooms)
		dungeon = new Dungeon(5);
		// Hero initialization
		hero = new Hero();

		System.out.println("Welcome to the Dungeon !");
		System.out.println("Are you ready to DIE ?");


	}

	public void death() {
		// TODO implement here
	}

	public void gameOver() {
		// TODO implement here
	}

}