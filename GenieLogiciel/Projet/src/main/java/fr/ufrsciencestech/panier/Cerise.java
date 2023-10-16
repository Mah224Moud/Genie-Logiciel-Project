package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class Cerise extends SimpleFruit{
    
    public Cerise() 
    {
        this(0.6, "Italie");
    }
    
    public Cerise(double prix, String origine) 
    {
	super(prix, origine);
    }

    @Override
    public String toString(){
        return "Cerise de " + this.getOrigine() + " à " + this.getPrix() + " €";
    }
}
