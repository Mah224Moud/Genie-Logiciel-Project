package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
 */
public class Mangue extends SimpleFruit {
    /**
     * Default constructor for the Mangue class.
     * It creates a Mangue object with a price of 1.5 and an origin of "Honduras".
     *
     * @return An instance of the Mangue class.
     */
    public Mangue() {
        this(1.5, "Honduras");
    }

    /**
     * Constructor for the Mangue class with specified price and origin.
     * It creates a Mangue object with the given price and origin.
     *
     * @param prix    The price of the Mangue.
     * @param origine The origin of the Mangue.
     * @return An instance of the Mangue class.
     */
    public Mangue(double prix, String origine) {
        super(prix, origine);
    }

    /**
     * This method returns a string representation of the Mangue object.
     * The string representation includes the origin and price of the Mangue.
     *
     * @return String The string representation of the Mangue object.
     */
    @Override
    public String toString() {
        return "Mangue du " + getOrigine() + " à " + getPrix() + " €";
    }

    // tests fonctionnels
    /*
     * public static void main(String[] args) {
     * // Création d'une mangue pour les tests
     * Mangue mangue = new Mangue(1.5, "Honduras");
     * 
     * // Test fonctionnel : Vérification du prix
     * if (mangue.getPrix() == 1.5) {
     * System.out.println("Test du prix réussi");
     * } else {
     * System.out.println("Test du prix échoué");
     * }
     * 
     * // Test fonctionnel 2: Vérification de l'origine
     * if ("Honduras".equals(mangue.getOrigine())) {
     * System.out.println("Test de l'origine réussi");
     * } else {
     * System.out.println("Test de l'origine échoué");
     * }
     * }
     */
}
