/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author salim1417
 */
public class Mangue extends SimpleFruit {
    public Mangue() {
        this(1.5, "Honduras");
    }

    public Mangue(double prix, String origine) {
        super(prix, origine);
    }

    @Override
    public String toString() {
        return "Mangue du " + getOrigine() + " à " + getPrix() + " €";
    }

     //tests fonctionnels
    /*public static void main(String[] args) {
        // Création d'une mangue pour les tests
        Mangue mangue = new Mangue(1.5, "Honduras");

         // Test fonctionnel : Vérification du prix
        if (mangue.getPrix() == 1.5) {
            System.out.println("Test du prix réussi");
        } else {
            System.out.println("Test du prix échoué");
        }

         // Test fonctionnel 2: Vérification de l'origine
        if ("Honduras".equals(mangue.getOrigine())) {
            System.out.println("Test de l'origine réussi");
        } else {
            System.out.println("Test de l'origine échoué");
        }
     }*/
}
