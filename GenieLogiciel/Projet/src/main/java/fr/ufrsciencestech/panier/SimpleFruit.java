/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author msalim1417
 */
public class SimpleFruit implements Fruit{
    private double prix;
    private String origine;
    
    
    public SimpleFruit(double prix, String origine) {
        if (prix < 0)
            this.prix = Math.abs(prix);
        else
            this.prix = prix;

        if (origine.equals(""))
            this.origine = "Origine inconnu";
        else
            this.origine = origine;
    }
    public boolean isSeedless(){
        return false;
    }
    public double getPrix(){
        return this.prix;
    }
    
    public String getOrigine(){
        return this.origine;
    }
    
    @Override
    public String toString() {
        return "Fruit de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o) { 
        if (o != null && getClass() == o.getClass()) {
            Banane or = (Banane) o;
            return (prix == or.getPrix() && origine.equals(or.getOrigine()));
        }
        return false;
    }

    public static void main(String[] args) {
        // Création d'un fruit pour les tests
        SimpleFruit fruit = new SimpleFruit(2.0, "France");

        // Test 1: Vérification du prix
        if (fruit.getPrix() == 2.0) {
            System.out.println("Test du prix réussi");
        } else {
            System.out.println("Test du prix échoué");
        }

        // Test 2: Vérification de l'origine
        if ("France".equals(fruit.getOrigine())) {
            System.out.println("Test de l'origine réussi");
        } else {
            System.out.println("Test de l'origine échoué");
        }

        // Test 3: Vérification de la méthode toString
        if ("Fruit de France a 2.0 euros".equals(fruit.toString())) {
            System.out.println("Test de toString réussi");
        } else {
            System.out.println("Test de toString échoué");
        }

        // Test 4: Vérification de la méthode equals
        SimpleFruit fruitIdentique = new SimpleFruit(2.0, "France");
        SimpleFruit fruitDifferent = new SimpleFruit(3.0, "Espagne");
        if (fruit.equals(fruitIdentique)) {
            System.out.println("Test d'egalité avec un fruit identique réussi");
        } else {
            System.out.println("Test d'egalité avec un fruit identique échoué");
        }
        if (!fruit.equals(fruitDifferent)) {
            System.out.println("Test d'egalité avec un fruit différent réussi");
        } else {
            System.out.println("Test d'egalité avec un fruit différent échoué");
        }

        // Test 5: Vérification de la méthode isSeedless
        if (!fruit.isSeedless()) {
            System.out.println("Test de isSeedless réussi");
        } else {
            System.out.println("Test de isSeedless échoué");
        }
    }
    
}

    @Override
    public void setPrix(Double prix) {
        this.prix = prix;
    }

}
