/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
 */
public class Fraise extends SimpleFruit{
    public Fraise() {
        this(0.35, "Hawai");
    }

    public Fraise(double prix, String origine) {
        super(prix, origine);
    }

    @Override
    public String toString() {
        return "Fraise de " + this.getOrigine() + " à " + this.getPrix() + " €";
    }

    public static void main(String[] args) {
        // Création d'une fraise pour les tests
        Fraise fraise = new Fraise(0.35, "Hawai");

        // Test fonctionnel : Vérification du prix
        if (fraise.getPrix() == 0.35) {
            System.out.println("Test du prix réussi");
        } else {
            System.out.println("Test du prix échoué");
        }

        // Test fonctionnel : Vérification de l'origine
        if ("Hawai".equals(fraise.getOrigine())) {
            System.out.println("Test de l'origine réussi");
        } else {
            System.out.println("Test de l'origine échoué");
        }
    }
}
