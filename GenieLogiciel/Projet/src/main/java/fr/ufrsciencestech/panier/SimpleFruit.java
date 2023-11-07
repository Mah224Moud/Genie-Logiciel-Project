/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author msalim1417
 */
public class SimpleFruit implements Fruit {
    private double prix;
    private String origine;

    /**
     * Constructor for the SimpleFruit class with specified price and origin.
     * It creates a SimpleFruit object with the given price and origin.
     * If the price is negative, it sets the price to the absolute value of the
     * given price.
     * If the origin is an empty string, it sets the origin to "Origine inconnu".
     *
     * @param prix    The price of the SimpleFruit.
     * @param origine The origin of the SimpleFruit.
     * @return An instance of the SimpleFruit class.
     */
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

    /**
     * This method checks if the SimpleFruit is seedless.
     * It always returns false because a SimpleFruit is not seedless.
     *
     * @return boolean Whether the SimpleFruit is seedless.
     */
    public boolean isSeedless() {
        return false;
    }

    /**
     * This method gets the price of the SimpleFruit.
     *
     * @return double The price of the SimpleFruit.
     */
    public double getPrix() {
        return this.prix;
    }

    /**
     * This method gets the origin of the SimpleFruit.
     *
     * @return String The origin of the SimpleFruit.
     */
    public String getOrigine() {
        return this.origine;
    }

    /**
     * This method returns a string representation of the SimpleFruit object.
     * The string representation includes the origin and price of the SimpleFruit.
     *
     * @return String The string representation of the SimpleFruit object.
     */
    @Override
    public String toString() {
        return "Fruit de " + origine + " a " + prix + " euros";
    }

    /**
     * This method checks if the SimpleFruit is equal to another object.
     * It checks if the other object is not null, is an instance of the SimpleFruit
     * class, and has the same price and origin as the SimpleFruit.
     *
     * @param o The object to be compared with the SimpleFruit.
     * @return boolean Whether the SimpleFruit is equal to the other object.
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            Banane or = (Banane) o;
            return (prix == or.getPrix() && origine.equals(or.getOrigine()));
        }
        return false;
    }

    /**
     * This method sets the price of the SimpleFruit.
     * If the given price is negative, it sets the price to the absolute value of
     * the given price.
     *
     * @param prix The new price of the SimpleFruit.
     * @return void
     */
    @Override
    public void setPrix(Double prix) {
        if (prix < 0)
            this.prix = -prix;
        else
            this.prix = prix;
    }

    /**
     * This method sets the origin of the SimpleFruit.
     *
     * @param origine The new origin of the SimpleFruit.
     * @return void
     */
    @Override
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    // tests fonctionnels
    /*
     * public static void main(String[] args) {
     * // Création d'un fruit pour les tests
     * SimpleFruit fruit = new SimpleFruit(2.0, "France");
     * 
     * // Test 1: Vérification du prix
     * if (fruit.getPrix() == 2.0) {
     * System.out.println("Test du prix réussi");
     * } else {
     * System.out.println("Test du prix échoué");
     * }
     * 
     * // Test 2: Vérification de l'origine
     * if ("France".equals(fruit.getOrigine())) {
     * System.out.println("Test de l'origine réussi");
     * } else {
     * System.out.println("Test de l'origine échoué");
     * }
     * 
     * // Test 3: Vérification de la méthode toString
     * if ("Fruit de France a 2.0 euros".equals(fruit.toString())) {
     * System.out.println("Test de toString réussi");
     * } else {
     * System.out.println("Test de toString échoué");
     * }
     * 
     * // Test 4: Vérification de la méthode equals
     * SimpleFruit fruitIdentique = new SimpleFruit(2.0, "France");
     * SimpleFruit fruitDifferent = new SimpleFruit(3.0, "Espagne");
     * if (fruit.equals(fruitIdentique)) {
     * System.out.println("Test d'egalité avec un fruit identique réussi");
     * } else {
     * System.out.println("Test d'egalité avec un fruit identique échoué");
     * }
     * if (!fruit.equals(fruitDifferent)) {
     * System.out.println("Test d'egalité avec un fruit différent réussi");
     * } else {
     * System.out.println("Test d'egalité avec un fruit différent échoué");
     * }
     * 
     * // Test 5: Vérification de la méthode isSeedless
     * if (!fruit.isSeedless()) {
     * System.out.println("Test de isSeedless réussi");
     * } else {
     * System.out.println("Test de isSeedless échoué");
     * }
     * }
     */

}
