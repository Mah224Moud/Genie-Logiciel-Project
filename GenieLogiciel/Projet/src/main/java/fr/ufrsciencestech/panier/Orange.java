package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class Orange extends SimpleFruit{
	
    public Orange() 
    {
        this(0.9, "Etats Unies");
    }
    
    public Orange(double prix, String origine) 
    {
	super(prix, origine);
    }
    @Override
    public String toString(){
        return "Orange des " + getOrigine() + " à " + getPrix() + " €";
    }
}
