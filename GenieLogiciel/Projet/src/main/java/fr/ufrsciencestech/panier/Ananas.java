package fr.ufrsciencestech.panier;

/**
 * Classe Ananas
 * 
 * @author salim1417
 */
public class Ananas extends SimpleFruit {

    /**
     * Default constructor for the Ananas class.
     * It creates an Ananas object with a price of 0.5 and an origin of "Brésil".
     *
     * @return An instance of the Ananas class.
     */
    public Ananas() {
        this(0.5, "Brésil");
    }

    /**
     * Constructor for the Ananas class with specified price and origin.
     * It creates an Ananas object with the given price and origin.
     *
     * @param prix    The price of the Ananas.
     * @param origine The origin of the Ananas.
     * @return An instance of the Ananas class.
     */
    public Ananas(double prix, String origine) {
        super(prix, origine);
    }

    /**
     * This method returns a string representation of the Ananas object.
     * The string representation includes the origin and price of the Ananas.
     *
     * @return String The string representation of the Ananas object.
     */
    @Override
    public String toString() {
        return "Ananas du " + getOrigine() + " à " + getPrix() + " €";
    }

    // tests fonctionnels
    /*
     * public static void main(String[] args) {
     * // Création d'un ananas pour les tests
     * Ananas ananas = new Ananas(0.5, "Brésil");
     * 
     * // Test fonctionnel : Vérification du prix
     * if (ananas.getPrix() == 0.5) {
     * System.out.println("Test du prix réussi");
     * } else {
     * System.out.println("Test du prix échoué");
     * }
     * 
     * // Test fonctionnel : Vérification de l'origine
     * if ("Brésil".equals(ananas.getOrigine())) {
     * System.out.println("Test de l'origine réussi");
     * } else {
     * System.out.println("Test de l'origine échoué");
     * }
     * 
     * }
     */
}
