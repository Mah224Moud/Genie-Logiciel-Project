package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
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
    
    //tests fonctionnels
   /* public static void main(String[] args) {
        // Création d'une cerise  pour les tests
        Cerise cerise = new Cerise(0.6, "Italie");

	// Test fonctionnel : Vérification du prix
        if (cerise.getPrix() == 0.6) {
            System.out.println("Test du prix réussi");
        } else {
            System.out.println("Test du prix échoué");
        }

	 // Test fonctionnel : Vérification de l'origine
        if ("Italie".equals(cerise.getOrigine())) {
            System.out.println("Test de l'origine réussi");
        } else {
            System.out.println("Test de l'origine échoué");
        }
    }*/
}
