package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
 */
public class Cerise extends SimpleFruit {

    /**
     * Default constructor for the Cerise class.
     * It creates a Cerise object with a price of 0.6 and an origin of "Italie".
     *
     * @return An instance of the Cerise class.
     */
    public Cerise() {
        this(0.6, "Italie");
    }

    /**
     * Constructor for the Cerise class with specified price and origin.
     * It creates a Cerise object with the given price and origin.
     *
     * @param prix    The price of the Cerise.
     * @param origine The origin of the Cerise.
     * @return An instance of the Cerise class.
     */
    public Cerise(double prix, String origine) {
        super(prix, origine);
    }

    /**
     * This method returns a string representation of the Cerise object.
     * The string representation includes the origin and price of the Cerise.
     *
     * @return String The string representation of the Cerise object.
     */
    @Override
    public String toString() {
        return "Cerise de " + this.getOrigine() + " à " + this.getPrix() + " €";
    }

    // tests fonctionnels
    /*
     * public static void main(String[] args) {
     * // Création d'une cerise pour les tests
     * Cerise cerise = new Cerise(0.6, "Italie");
     * 
     * // Test fonctionnel : Vérification du prix
     * if (cerise.getPrix() == 0.6) {
     * System.out.println("Test du prix réussi");
     * } else {
     * System.out.println("Test du prix échoué");
     * }
     * 
     * // Test fonctionnel : Vérification de l'origine
     * if ("Italie".equals(cerise.getOrigine())) {
     * System.out.println("Test de l'origine réussi");
     * } else {
     * System.out.println("Test de l'origine échoué");
     * }
     * }
     */
}
