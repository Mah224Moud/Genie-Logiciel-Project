package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
 */
public class Orange extends SimpleFruit {

    /**
     * Default constructor for the Orange class.
     * It creates an Orange object with a price of 0.9 and an origin of "Etats
     * Unies".
     *
     * @return An instance of the Orange class.
     */
    public Orange() {
        this(0.9, "Etats Unies");
    }

    /**
     * Constructor for the Orange class with specified price and origin.
     * It creates an Orange object with the given price and origin.
     *
     * @param prix    The price of the Orange.
     * @param origine The origin of the Orange.
     * @return An instance of the Orange class.
     */
    public Orange(double prix, String origine) {
        super(prix, origine);
    }

    /**
     * This method returns a string representation of the Orange object.
     * The string representation includes the origin and price of the Orange.
     *
     * @return String The string representation of the Orange object.
     */
    @Override
    public String toString() {
        return "Orange des " + getOrigine() + " à " + getPrix() + " €";
    }

    // tests fonctionnels
    /*
     * public static void main(String[] args) {
     * // Création d'une orange avec des paramètres pour les tests
     * Orange orange = new Orange(0.9, "Etats Unies");
     * 
     * // Test fonctionnel : Vérification du prix
     * if (orange.getPrix() == 0.9) {
     * System.out.println("Test du prix réussi");
     * } else {
     * System.out.println("Test du prix échoué");
     * }
     * 
     * // Test fonctionnel : Vérification de l'origine
     * if ("Etats Unies".equals(orange.getOrigine())) {
     * System.out.println("Test de l'origine réussi");
     * } else {
     * System.out.println("Test de l'origine échoué");
     * }
     * }
     */
}
