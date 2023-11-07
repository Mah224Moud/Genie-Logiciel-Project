package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class PanierVideException extends Exception {
    /**
     * Default constructor for the PanierVideException class.
     * It creates a PanierVideException object with a default message "Suppression
     * impossible car le panier est vide !".
     *
     * @return An instance of the PanierVideException class.
     */
    public PanierVideException() {
        super("Suppression impossible car le panier est vide !");
    }
}
