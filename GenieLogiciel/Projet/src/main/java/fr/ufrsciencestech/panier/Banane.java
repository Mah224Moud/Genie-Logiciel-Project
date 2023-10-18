package fr.ufrsciencestech.panier;

/**
 *
 * @author mamoudou
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
}