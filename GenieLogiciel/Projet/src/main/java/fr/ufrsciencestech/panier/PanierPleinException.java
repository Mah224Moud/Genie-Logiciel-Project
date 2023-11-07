package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class PanierPleinException extends Exception {

    /**
     * Default constructor for the PanierPleinException class.
     * It creates a PanierPleinException object with a default message "Ajout
     * impossible car le panier est plein !".
     *
     * @return An instance of the PanierPleinException class.
     */
    public PanierPleinException() {
        super("Ajout impossible car le panier est plein !");
    }
}
