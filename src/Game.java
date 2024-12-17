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

	public void moveToRoom(int newRoom) {
		Dungeon.Room = newRoom; // Mise à jour de la salle actuelle
		System.out.println("You moved to room: " + Dungeon.Room);

		// Vérifie si la condition de victoire est remplie
		winner();
	}

	public void winner() {
		if (Dungeon.Room == 0) {
			System.out.println("Congratulations! You have found the treasure and successfully completed the dungeon. " +
					"Your adventure ends here. Well done!");
			// Autres actions possibles : arrêter le jeu, sauvegarder la partie, etc.
		}
	}
}