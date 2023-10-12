package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class PanierPleinException extends Exception {
    
    public PanierPleinException()
    {
	super("Ajout impossible car le panier est plein !");
    }

}
