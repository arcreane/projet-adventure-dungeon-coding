package Characters;

import Weapons.Weapon;

/**
 *
 */
public class Character(String name, int healthPoints) {
    this.name = name;
    this.healthPoints = healthPoints;
    this.isParalyzed = false;
    this.paralysisTurns = 0;



    /**
     * Default constructor
     */
public Character() {
        private String name;
        private int healthPoints;
        private boolean isParalyzed;  // Pour savoir si le personnage est paralysé
        private int paralysisTurns;    // Nombre de tours restants de paralysie


    }

    // Méthode pour attaquer l'adversaire
    public void attack (Character opponent){
        if (isParalyzed) {
            System.out.println(name + " est paralysé et ne peut pas attaquer !");
        } else {
            int damage = 10;  // Exemple de dommage
            opponent.takeDamage(damage);
            System.out.println(name + " attaque " + opponent.getName() + " et inflige " + damage + " points de dégâts.");
        }
    }

    // Méthode pour recevoir des dégâts
    public void takeDamage ( int damage){
        healthPoints -= damage;
        if (healthPointsp < 0) {
            healthPoints = 0;
        }
        System.out.println(name + " a " + healthPoints + " points de vie restants.");
    }

    // Méthode pour infliger la paralysie à un personnage
    public void paralyze ( int turns){
        isParalyzed = true;
        paralysisTurns = turns;
        System.out.println(name + " a été paralysé et sera immobile pendant " + turns + " tours.");
    }

    // Méthode pour mettre à jour l'état de paralysie à chaque tour
    public void updateStatus () {
        if (isParalyzed) {
            paralysisTurns--;
            if (paralysisTurns <= 0) {
                isParalyzed = false;
                System.out.println(name + " n'est plus paralysé et peut maintenant agir !");
            }
        }
    }

    // Getter pour le nom du personnage
    public String getName () {
        return name;
    }

    // Vérifie si le personnage est paralysé
    public boolean isParalyzed () {
        return isParalyzed;
    }

    // Getter pour les points de vie
    public int getHp () {
        return healthPoints;
    }


    /**
     *
     */
    public int healthPoints;

    /**
     *
     */
    public Weapon currentWeapon;

    /**
     * @param character
     */
    public void attack (Character character){
        // TODO implement here
    }

}