package fr.ufrsciencestech.panier;

/**
 * Classe Ananas
  * @author salim1417
 */
public class Ananas extends SimpleFruit {

    public Ananas() {
        this(0.5, "Brésil");
    }

    public Ananas(double prix, String origine) {
        super(prix, origine);
    }

    @Override
    public String toString() {
        return "Ananas du " + getOrigine() + " à " + getPrix() + " €";
    }
     public static void main(String[] args) {
        // Création d'un ananas pour les tests
        Ananas ananas = new Ananas(0.5, "Brésil");

        // Test fonctionnel : Vérification du prix
        if (ananas.getPrix() == 0.5) {
            System.out.println("Test du prix réussi");
        } else {
            System.out.println("Test du prix échoué");
        }

        // Test fonctionnel : Vérification de l'origine
        if ("Brésil".equals(ananas.getOrigine())) {
            System.out.println("Test de l'origine réussi");
        } else {
            System.out.println("Test de l'origine échoué");
        }

    }
}
