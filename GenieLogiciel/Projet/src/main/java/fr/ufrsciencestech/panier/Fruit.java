package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public interface Fruit {
    public boolean isSeedless(); // predicat indiquant si le fruit a ou non des pepins

    public double getPrix(); // prix unitaire du fruit (en euros)

    public String getOrigine(); // pays d'origine du fruit

    public void setOrigine(String origine); // modifier le pays d'origine

    public void setPrix(Double prix); // modifier le prix

    @Override
    public boolean equals(Object o); // predicat pour tester si 2 fruits sont equivalents

    @Override
    public String toString(); // affichage d'un fruit
}
