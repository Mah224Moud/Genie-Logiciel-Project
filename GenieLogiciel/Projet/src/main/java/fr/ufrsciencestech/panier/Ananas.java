package fr.ufrsciencestech.panier;

/**
 * Classe Ananas
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
    
}
