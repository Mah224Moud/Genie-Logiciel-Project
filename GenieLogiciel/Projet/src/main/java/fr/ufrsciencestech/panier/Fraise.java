package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
 */
public class Fraise extends SimpleFruit {
    /**
     * Default constructor for the Fraise class.
     * It creates a Fraise object with a price of 0.35 and an origin of "Hawai".
     *
     * @return An instance of the Fraise class.
     */
    public Fraise() {
        this(0.35, "Hawai");
    }

    /**
     * Constructor for the Fraise class with specified price and origin.
     * It creates a Fraise object with the given price and origin.
     *
     * @param prix    The price of the Fraise.
     * @param origine The origin of the Fraise.
     * @return An instance of the Fraise class.
     */
    public Fraise(double prix, String origine) {
        super(prix, origine);
    }

    /**
     * This method returns a string representation of the Fraise object.
     * The string representation includes the origin and price of the Fraise.
     *
     * @return String The string representation of the Fraise object.
     */
    @Override
    public String toString() {
        return "Fraise de " + this.getOrigine() + " à " + this.getPrix() + " €";
    }

    /*
     * public static void main(String[] args) {
     * // Création d'une fraise pour les tests
     * Fraise fraise = new Fraise(0.35, "Hawai");
     * 
     * // Test fonctionnel : Vérification du prix
     * if (fraise.getPrix() == 0.35) {
     * System.out.println("Test du prix réussi");
     * } else {
     * System.out.println("Test du prix échoué");
     * }
     * 
     * // Test fonctionnel : Vérification de l'origine
     * if ("Hawai".equals(fraise.getOrigine())) {
     * System.out.println("Test de l'origine réussi");
     * } else {
     * System.out.println("Test de l'origine échoué");
     * }
     * }
     */
}
