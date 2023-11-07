package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
 */
public class Banane extends SimpleFruit {

    /**
     * Default constructor for the Banane class.
     * It creates a Banane object with a price of 0.5 and an origin of "Espagne".
     *
     * @return An instance of the Banane class.
     */
    public Banane() {
        this(0.5, "Espagne");
    }

    /**
     * Constructor for the Banane class with specified price and origin.
     * It creates a Banane object with the given price and origin.
     *
     * @param prix    The price of the Banane.
     * @param origine The origin of the Banane.
     * @return An instance of the Banane class.
     */
    public Banane(double prix, String origine) {
        super(prix, origine);
    }

    /**
     * This method returns a string representation of the Banane object.
     * The string representation includes the origin and price of the Banane.
     *
     * @return String The string representation of the Banane object.
     */
    @Override
    public String toString() {
        return "Banane de " + this.getOrigine() + " à " + this.getPrix() + " €";
    }
    // tests fonctionnels
    /*
     * public static void main(String[] args) {
     * // Création d'une banane pour les tests
     * Banane banane = new Banane(0.5, "Espagne");
     * 
     * // Test fonctionnel : Vérification du prix
     * if (banane.getPrix() == 0.5) {
     * System.out.println("Test du prix réussi");
     * } else {
     * System.out.println("Test du prix échoué");
     * }
     * 
     * // Test fonctionnel : Vérification de l'origine
     * if ("Espagne".equals(banane.getOrigine())) {
     * System.out.println("Test de l'origine réussi");
     * } else {
     * System.out.println("Test de l'origine échoué");
     * }
     * }
     */
}
