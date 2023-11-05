package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
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
//tests fonctionnels
    /*public static void main(String[] args) {
        // Création d'une orange avec des paramètres pour les tests
        Orange orange = new Orange(0.9, "Etats Unies");

	// Test fonctionnel : Vérification du prix
        if (orange.getPrix() == 0.9) {
            System.out.println("Test du prix réussi");
        } else {
            System.out.println("Test du prix échoué");
        }

	// Test fonctionnel : Vérification de l'origine
        if ("Etats Unies".equals(orange.getOrigine())) {
            System.out.println("Test de l'origine réussi");
        } else {
            System.out.println("Test de l'origine échoué");
        }
    }*/
}
