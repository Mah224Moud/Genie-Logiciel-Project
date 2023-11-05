package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
 */
public class Banane extends SimpleFruit {

    public Banane() {
        this(0.5, "Espagne");
    }

    public Banane(double prix, String origine) {
        super(prix, origine);
    }

    @Override
    public String toString() {
        return "Banane de " + this.getOrigine() + " à " + this.getPrix() + " €";
    }
    //tests fonctionnels
    /*public static void main(String[] args) {
        // Création d'une banane pour les tests
        Banane banane = new Banane(0.5, "Espagne");
        
        // Test fonctionnel : Vérification du prix
        if (banane.getPrix() == 0.5) {
            System.out.println("Test du prix réussi");
        } else {
            System.out.println("Test du prix échoué");
        }

        // Test fonctionnel : Vérification de l'origine
        if ("Espagne".equals(banane.getOrigine())) {
            System.out.println("Test de l'origine réussi");
        } else {
            System.out.println("Test de l'origine échoué");
        }
    }*/
}
